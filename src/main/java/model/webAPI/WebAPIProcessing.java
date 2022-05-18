package model.webAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * WebAPIProcessing<br>
 * webAPIに関する処理
 * 
 *
 */
public class WebAPIProcessing {

	/**
	 * getWeatherInTokyo<br>
	 * 東京の天気を取得する
	 * 
	 */
	public int getWeatherInTokyo() {

		// webAPIのURL
		String openMeteoUrl = "https://api.open-meteo.com/v1/forecast?latitude=35.6785&longitude=139.6823&hourly=weathercode&timezone=Asia%2FTokyo";

		// 結果を格納する変数
		String result = "";
		HttpURLConnection con = null;
		BufferedReader in = null;

		try {
			URL url = new URL(openMeteoUrl);
			con = (HttpURLConnection) url.openConnection();
			con.connect();

			in = new BufferedReader(new InputStreamReader(con.getInputStream()));

			String tmp = "";

			while ((tmp = in.readLine()) != null) {
				result += tmp;
			}

			con.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				in.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			con.disconnect();
		}

		JSONObject json = new JSONObject(result);

		JSONObject hourly = json.getJSONObject("hourly");
		JSONArray weatherCode = hourly.getJSONArray("weathercode");
		int weatherCodeNow = weatherCode.getInt(0);

		return weatherCodeNow;

	}

}
