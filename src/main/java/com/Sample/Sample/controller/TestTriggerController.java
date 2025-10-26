package com.Sample.Sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Sample.Sample.dao.TestDao;
import com.Sample.Sample.dto.Account;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/test")
public class TestTriggerController {

	@Autowired
	private TestDao testDao;

	@PostMapping("/{platform}")
	public String runTest(@PathVariable String platform, @RequestBody Account account) {
	    System.out.println("Platform: " + platform + ", Username: " + account.getUsername());

	    if ("facebook".equals(platform)) {
	        testDao.runFacebookTest(account);
	    } else if ("instagram".equals(platform)) {
	        testDao.runInstagramTest(account);
	    }
	    return platform + " test executed for user: " + account.getUsername();
	}

}
