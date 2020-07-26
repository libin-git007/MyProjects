package com.li.org.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.li.org.entity.MyUserDetails;
import com.li.org.entity.ResponseData;
import com.li.org.enums.ResultCode;
import com.li.org.service.impl.UserDetailsServiceImpl;
import com.li.org.service.impl.UserPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * security 配置
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //@Autowired
    // CustomizeAuthenticationEntryPoint customizeAuthenticationEntryPoint;
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    UserPasswordEncoder userPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/login").permitAll()//允许访问
                .anyRequest().authenticated()//需要验证
                .and()
                .authenticationProvider(authenticationProvider())//用户名密码验证
                .httpBasic()
                .and()
                .formLogin()
                .permitAll()
                .successHandler(new AjaxAuthSuccessHandler())//登陆成功
                .failureHandler(new AjaxAuthFailHandler())//登陆失败
                .and()
                .logout()
                .logoutSuccessHandler(new logOutSuccessHander())//退出登陆
                .permitAll()
                .and()
                //未登陆时返回的信息
                .exceptionHandling()
                .authenticationEntryPoint(new CustomizeAuthenticationEntryPoint());//无权限访问

        //开启模拟请求，比如API POST测试工具的测试，不开启时，API POST会报403错误
        http.csrf().disable();//允许
        http.cors();//允许跨域
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.inMemoryAuthentication().withUser("admin").password("admin").roles("admin");
       // auth.userDetailsService(loginService);
    }

    @Override
    public void configure(WebSecurity web) {
        //对于在header里面增加token等类似情况，放行所有OPTIONS请求。
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }

    //定义登陆成功返回信息
    private class AjaxAuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
        @Override
        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
            MyUserDetails myUserDetails= (MyUserDetails) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
            ResponseData result = new ResponseData();
            result.setCode(ResultCode.SUCCESS.getCode());
            result.setMessage(ResultCode.SUCCESS.getMessage());
            result.setData(myUserDetails);
            result.setSuccess(true);

            //登陆成功后移除session中验证码信息
           // request.getSession().removeAttribute("codeValue");
          //  request.getSession().removeAttribute("codeTime");

            response.setContentType("application/json;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.write(JSON.toJSONString(result));
            out.flush();
            out.close();
        }
    }

    //定义登陆失败返回信息
    private class AjaxAuthFailHandler extends SimpleUrlAuthenticationFailureHandler {
        @Override
        public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
            ResponseData result = new ResponseData();
            result.setCode(ResultCode.COMMON_FAIL.getCode());
            result.setMessage(exception.getMessage());
            result.setSuccess(false);
            //登陆失败后移除session中验证码信息
           // request.getSession().removeAttribute("codeValue");
           // request.getSession().removeAttribute("codeTime");
            response.setContentType("application/json;charset=utf-8");

            // response.setStatus(HttpStatus.UNAUTHORIZED.value());
            PrintWriter out = response.getWriter();
            out.write(JSON.toJSONString(result));
            out.flush();
            out.close();
        }
    }

    //未登陆时返回信息
    private class CustomizeAuthenticationEntryPoint implements AuthenticationEntryPoint {
        @Override
        public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException {
            ResponseData result = new ResponseData();
            result.setCode(ResultCode.USER_NOT_LOGIN.getCode());
            result.setMessage(ResultCode.USER_NOT_LOGIN.getMessage());
            result.setSuccess(false);
            httpServletResponse.setContentType("text/json;charset=utf-8");
            httpServletResponse.getWriter().write(JSON.toJSONString(result));
        }
    }

    //退出登陆返回信息
    private class logOutSuccessHander implements LogoutSuccessHandler {

        @Override
        public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
            ResponseData result = new ResponseData();
            result.setCode(ResultCode.SUCCESS.getCode());
            result.setMessage(ResultCode.SUCCESS.getMessage());
            result.setSuccess(true);
            httpServletResponse.setContentType("application/json;charset=utf-8");
            PrintWriter out = httpServletResponse.getWriter();
            out.write(JSONObject.toJSONString(result));
            out.flush();
            out.close();
        }
    }

    @Bean
    public AuthenticationProvider authenticationProvider() throws UsernameNotFoundException {
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(userPasswordEncoder);
        provider.setHideUserNotFoundExceptions(false);//抛出用户未找到的异常
        return provider;
    }

}
