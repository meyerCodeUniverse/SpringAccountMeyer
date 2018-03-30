package beans;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
	@Bean
	public AccountDao accountDao() {
		AccountDaoInMemoryImpl bean = new AccountDaoInMemoryImpl();
		return bean;
	}
	
	@Bean(autowire=Autowire.BY_NAME)
	public AccountService accountService() {
		AccountServiceImpl bean = new AccountServiceImpl(accountDao());
		//bean.setAccountDao(accountDao());
		return bean;
	}
	
	@Bean
	public AccountDao accountDaoJpa() {
		AccountDaoJpaImpl bean = new AccountDaoJpaImpl();
		return bean;
	}
	

}