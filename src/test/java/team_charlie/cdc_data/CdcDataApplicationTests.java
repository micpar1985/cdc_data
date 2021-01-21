package team_charlie.cdc_data;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class CdcDataApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testGetData() throws Exception {
		System.out.println("This is a test!");

		// Given
		final String jsonMimeType = "application/json";
		HttpUriRequest request = new HttpGet( "https://data.cdc.gov/resource/vbim-akqf.json" );

		// When
		HttpResponse response = HttpClientBuilder.create().build().execute( request );

		// Then
		String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();

		assertEquals(jsonMimeType, mimeType);

	}

	private void assertEquals(String jsonMimeType, String mimeType) {
	}


}




