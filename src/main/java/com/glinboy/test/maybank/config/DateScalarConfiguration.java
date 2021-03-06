package com.glinboy.test.maybank.config;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import graphql.schema.GraphQLScalarType;

@Configuration
public class DateScalarConfiguration {

	@Bean
	public GraphQLScalarType localDateScalar() {
		return GraphQLScalarType.newScalar().name("LocalDate").description("Java 8 LocalDate as scalar.")
				.coercing(new Coercing<LocalDate, String>() {
					@Override
					public String serialize(final Object dataFetcherResult) {
						if (dataFetcherResult instanceof LocalDate) {
							return dataFetcherResult.toString();
						} else {
							throw new CoercingSerializeException("Expected a LocalDate object.");
						}
					}

					@Override
					public LocalDate parseValue(final Object input) {
						try {
							if (input instanceof String) {
								return LocalDate.parse((String) input);
							} else {
								throw new CoercingParseValueException("Expected a String");
							}
						} catch (DateTimeParseException e) {
							throw new CoercingParseValueException(String.format("Not a valid date: '%s'.", input), e);
						}
					}

					@Override
					public LocalDate parseLiteral(final Object input) {
						if (input instanceof StringValue) {
							try {
								return LocalDate.parse(((StringValue) input).getValue());
							} catch (DateTimeParseException e) {
								throw new CoercingParseLiteralException(e);
							}
						} else {
							throw new CoercingParseLiteralException("Expected a StringValue.");
						}
					}
				}).build();
	}
	
	@Bean
	public GraphQLScalarType localTimeScalar() {
		return GraphQLScalarType.newScalar().name("LocalTime").description("Java 8 LocalTime as scalar.")
				.coercing(new Coercing<LocalTime, String>() {
					@Override
					public String serialize(final Object dataFetcherResult) {
						if (dataFetcherResult instanceof LocalTime) {
							return dataFetcherResult.toString();
						} else {
							throw new CoercingSerializeException("Expected a LocalTime object.");
						}
					}

					@Override
					public LocalTime parseValue(final Object input) {
						try {
							if (input instanceof String) {
								return LocalTime.parse((String) input);
							} else {
								throw new CoercingParseValueException("Expected a String");
							}
						} catch (DateTimeParseException e) {
							throw new CoercingParseValueException(String.format("Not a valid time: '%s'.", input), e);
						}
					}

					@Override
					public LocalTime parseLiteral(final Object input) {
						if (input instanceof StringValue) {
							try {
								return LocalTime.parse(((StringValue) input).getValue());
							} catch (DateTimeParseException e) {
								throw new CoercingParseLiteralException(e);
							}
						} else {
							throw new CoercingParseLiteralException("Expected a StringValue.");
						}
					}
				}).build();
	}
}
