package com.sampleapp

import spock.lang.Specification
import grails.buildtestdata.mixin.Build

@Build(Publication)
class PublicationIntegrationSpec extends Specification {

	def setup() {
		Date currentDate = new Date() - 10
		10?.times { i ->
			Publication.build(datePublished: currentDate)
			currentDate = currentDate + 1
		}
	}

	def "canary test to see books are created from build test data plugin"() {
		expect: 
		Publication.count() == 10
	}

	def "recent publication count shoud be 7"() {
		expect:
		Publication.recentPublications().count() == 6
	}
}