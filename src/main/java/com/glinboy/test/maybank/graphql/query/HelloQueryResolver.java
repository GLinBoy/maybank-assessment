package com.glinboy.test.maybank.graphql.query;

import java.util.Optional;
import org.springframework.stereotype.Service;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Service
public class HelloQueryResolver implements GraphQLQueryResolver {

	public String hello(final String who) {
		return String.format("Hello, %s!", Optional.ofNullable(who).orElse("GraphQL"));
	}
}