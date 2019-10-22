package com.tangmo.xizhu.customer.config;

import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author chen bo
 * @Date 2019/10/20
 * @Version V1.0
 * @Description: shiro登录管理
 **/
@Configuration
public class ShiroConfig {
    @Bean
    public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //添加强制退出和登出拦截
        Map<String, Filter> filters = new LinkedHashMap<>();
        filters.put("jwt", new JWTFilter());

        LogoutFilter logoutFilter = new LogoutFilter();
        //配置成功登出跳转的uri
        logoutFilter.setRedirectUrl("/xizhu/logout"); //退出操作 待定
        filters.put("logout", logoutFilter);
        shiroFilterFactoryBean.setFilters(filters);
        shiroFilterFactoryBean.setUnauthorizedUrl("/pacs/401");
        /**
         * 拦截器
         *
         * 配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
         * anno代表不需要授权即可访问，对于静态资源，访问权限都设置为anno
         * authc表示需要登录才可访问
         * /userList=roles[admin]的含义是要访问/userList需要有admin这个角色，如果没有此角色访问此URL会返回无授权页面
         * /userList=authc,perms[/userList]的含义是要访问/userList需要有/userList的权限，要是没分配此权限访问此URL会返回无授权页面
         */
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/login", "anon");
//        filterChainDefinitionMap.put("/user/pwd/change", "jwt");
//        filterChainDefinitionMap.put("/user/pwd/**", "anon");
//        filterChainDefinitionMap.put("/login/project", "jwt");
        filterChainDefinitionMap.put("/swagger-ui.html", "anon");
        filterChainDefinitionMap.put("/swagger-resources", "anon");
        filterChainDefinitionMap.put("/swagger-resources/configuration/security", "anon");
        filterChainDefinitionMap.put("/swagger-resources/configuration/ui", "anon");
        filterChainDefinitionMap.put("/v2/api-docs", "anon");
        filterChainDefinitionMap.put("/webjars/springfox-swagger-ui/**", "anon");
        filterChainDefinitionMap.put("/**", "jwt");
        filterChainDefinitionMap.put("/401", "anon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
//        shiroFilterFactoryBean.setLoginUrl("/login/unauth");
        return shiroFilterFactoryBean;
    }


    @Bean
    public MyRealm myRealm() {
        MyRealm myRealm = new MyRealm();
        return myRealm;
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //设置realm.
        securityManager.setRealm(myRealm());
        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
        subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
        securityManager.setSubjectDAO(subjectDAO);
        return securityManager;
    }


    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator daapc = new DefaultAdvisorAutoProxyCreator();
        daapc.setProxyTargetClass(true);
        return daapc;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(){
        AuthorizationAttributeSourceAdvisor aas = new AuthorizationAttributeSourceAdvisor();
        aas.setSecurityManager(securityManager());
        return aas;
    }
}
