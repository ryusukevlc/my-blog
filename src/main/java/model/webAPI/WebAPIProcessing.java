package model.webAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

		//取得結果をjsonに変換する
		JSONObject json = new JSONObject(result);

		JSONObject hourly = json.getJSONObject("hourly");
		JSONArray timeArray = hourly.getJSONArray("time");
		
		LocalDateTime nowDate = LocalDateTime.now();
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH");
		
		String formattedDate = nowDate.format(dateFormatter);
		String formattedTime = nowDate.format(timeFormatter);
		String formattedDateTime = formattedDate + "T" + formattedTime + ":00";
		
		int index = 0;
		
		//現在時刻のインデックスを取得する
		for (int i = 0 ; i < timeArray.length() ; i++) {
			if (formattedDateTime.equals(timeArray.get(i))) {
				index = i;
			}
		}
		
		
		JSONArray weatherCodeArray = hourly.getJSONArray("weathercode");
		
		//取得したインデックスから天気コードを取得する
		int weatherCode = weatherCodeArray.getInt(index);

		return weatherCode;

	}

}
