package com.regex.data.conttroller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.regex.data.model.Match;
import com.regex.data.model.Regexmodel;

//http://localhost:8088/regex/match1
@RestController
@RequestMapping("/regex")
public class RegexResource {

	// check point
	@GetMapping("/aa/{id}")
	public String mm(@PathVariable(value = "id") String id) {
		return "ll";
	}

	// method as per requirement
	@PostMapping("/match")
	public Match matchString(@RequestBody Regexmodel m) {
		System.out.println("innnn" + m.getRegex());
		Match mm = new Match();

		String theGroup = "";
		Pattern pattern = Pattern.compile(m.getRegex());
		Matcher matcher = pattern.matcher(m.getTextbody());
		int matches = 0;
		while (matcher.find()) {
			matches++;

			theGroup = matcher.group();
		}
		if (matches > 0) {
			mm.setMatch(theGroup);
			mm.setError(false);
		} else {
			mm.setMatch(null);
			mm.setError(true);
		}
		return mm;

	}

}
