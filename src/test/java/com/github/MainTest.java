package com.github;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@RunWith(JUnitPlatform.class)
@SpringBootTest
@MockitoSettings(strictness = Strictness.LENIENT)
public class MainTest {

	@Test
	public void dummyTest() {
		assert true;
	}
}
