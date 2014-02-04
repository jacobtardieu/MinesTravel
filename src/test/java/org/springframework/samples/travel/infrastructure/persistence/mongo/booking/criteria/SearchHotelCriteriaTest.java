package org.springframework.samples.travel.infrastructure.persistence.mongo.booking.criteria;

import static org.mockito.Mockito.when;

import org.fest.assertions.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.samples.travel.domain.shared.SearchCriteria;

@RunWith(MockitoJUnitRunner.class)
public class SearchHotelCriteriaTest {

	@Mock
	private SearchCriteria searchCriteria;

	@InjectMocks
	private SearchHotelCriteria searchHotelCriteria;

	@Test
	public void shouldCreateRightMongoQuery() {
		when(searchCriteria.getPage()).thenReturn(0);
		when(searchCriteria.getPageSize()).thenReturn(5);
		when(searchCriteria.getSearchString()).thenReturn("");
		
		searchHotelCriteria = SearchHotelCriteria.newSearchHotelCriteria(searchCriteria);

		// When
		Query result = searchHotelCriteria.toMongoQuery();

		// Then
		
		Assertions.assertThat(result.getLimit()).isEqualTo(5);
		Assertions.assertThat(result.getSkip()).isEqualTo(0);
		
	}

}
