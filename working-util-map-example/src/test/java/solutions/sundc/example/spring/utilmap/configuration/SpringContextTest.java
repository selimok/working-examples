package solutions.sundc.example.spring.utilmap.configuration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import solutions.sundc.example.spring.utilmap.MyEnum;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")
public class SpringContextTest {

	/**
	 * Attention: Using @Autowired annotation here cause FatalBeanException with the
	 * message :
	 * "Key type [class solutions.sundc.example.spring.utilmap.MyEnum] of map [java.util.Map] must be assignable to [java.lang.String]"
	 */
	@Resource(name = "myMapping")
	Map<MyEnum, String> myMapping;

	@Test
	public void shouldInitializeMyMapping() {
		assertNotNull(myMapping);
		assertEquals("value1", myMapping.get(MyEnum.ENUM1));
	}

}
