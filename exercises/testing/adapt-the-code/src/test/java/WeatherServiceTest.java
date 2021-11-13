import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.mockito.Mockito.*;

public final class WeatherServiceTest {

    @Test
    void exampleTest() {
        assertThat(1 + 1, is(2));
    }

    @Test
    void getWeatherTodayWithValidWeatherIsCorrect(){
        HttpClient client = new HttpClient() {
            @Override
            public String get(String url) throws IOException {
                return "Sunny";
            }
        };
        WeatherService ws = new WeatherService(client);
        assertThat(ws.getWeatherToday(), is(Weather.SUNNY));
    }

    @Test
    void getWeatherTodayWithValidWeatherIsCorrectRainy(){
        HttpClient client = new HttpClient() {
            @Override
            public String get(String url) throws IOException {
                return "Rainy";
            }
        };
        WeatherService ws = new WeatherService(client);
        assertThat(ws.getWeatherToday(), is(Weather.RAINY));
    }

    @Test
    void getWeatherTodayWithValidWeatherIsCorrectSnowy(){
        HttpClient client = new HttpClient() {
            @Override
            public String get(String url) throws IOException {
                return "Snowy";
            }
        };
        WeatherService ws = new WeatherService(client);
        assertThat(ws.getWeatherToday(), is(Weather.SNOWY));
    }
    @Test
    void getWeatherTodayWithValidWeatherIsCorrectQuestionMark(){
        HttpClient client = new HttpClient() {
            @Override
            public String get(String url) throws IOException {
                return "???";
            }
        };
        WeatherService ws = new WeatherService(client);
        assertThat(ws.getWeatherToday(), is(Weather.ITS_RAINING_MEN_HALLELUJAH));
    }

    @Test
    void getWeatherTodayWithInvalidWeatherIsCorrect(){
        HttpClient client = new HttpClient() {
            @Override
            public String get(String url) throws IOException {
                return "i don't know";
            }
        };
        WeatherService ws = new WeatherService(client);
        assertThat(ws.getWeatherToday(), is(Weather.UNKNOWN));
    }

    @Test
    void getWeatherTodayThrowsException(){
        HttpClient client = new HttpClient() {
            @Override
            public String get(String url) throws IOException {
                throw new IOException();
            }
        };
        WeatherService ws = new WeatherService(client);
        assertThat(ws.getWeatherToday(), is(Weather.UNKNOWN));
    }

    @Test
    public void mockito_getWeatherTodayWithValidWeatherIsCorrect() throws IOException {
        HttpClient client = mock(HttpClient.class);
        when(client.get(anyString())).thenReturn("Sunny");
        WeatherService ws = new WeatherService(client);
        assertThat(ws.getWeatherToday(), is(Weather.SUNNY));
    }

    @Test
    public void mockito_getWeatherTodayWithInvalidWeatherIsCorrect() throws IOException {
        HttpClient client = mock(HttpClient.class);
        when(client.get(anyString())).thenReturn("invalid_weather");
        WeatherService ws = new WeatherService(client);
        assertThat(ws.getWeatherToday(), is(Weather.UNKNOWN));
    }

    @Test
    public void mockito_getWeatherTodayReturnsUnknownOnException() throws IOException {
        HttpClient client = mock(HttpClient.class);
        when(client.get(anyString())).thenThrow(new IOException());
        WeatherService ws = new WeatherService(client);
        assertThat(ws.getWeatherToday(), is(Weather.UNKNOWN));
    }
}
