package com.grp3.logic.parsers;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.grp3.SpringCrowdFundingApplication;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= SpringCrowdFundingApplication.class)
@WebAppConfiguration
@SpringBootTest
public class YTLinkParserTests {

	private static final String VALID_YTUBE_LINK = "https://www.youtube.com/watch?v=tJKAQggSs9Q";
	private static final String INVALID_YTUBE_LINK = "https://www.youtube.com/watch";
	
	private static final String VID_CODE = "tJKAQggSs9Q";
	
	@Autowired
	private IYTLinkParser _linkParser;
	
	@Test
	public void validLink() {
		String code = _linkParser.parseLinkForVidCode(VALID_YTUBE_LINK);
		assertEquals(VID_CODE, code);
	}
	
	@Test
	public void invalidLink() {
		String code = _linkParser.parseLinkForVidCode(INVALID_YTUBE_LINK);
		assertNull(code);
	}
}
