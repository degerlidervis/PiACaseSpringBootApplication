package com.PiACase.CommandLine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Runner implements CommandLineRunner{
	
    private static final Logger log = LoggerFactory.getLogger(Runner.class);
	

	@Override
	public void run(String... args) throws Exception {
		log.info(args.toString());
	}
}
