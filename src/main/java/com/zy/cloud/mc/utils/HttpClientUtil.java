package com.zy.cloud.mc.utils;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;

public class HttpClientUtil {

	private static RequestConfig CONFIG = RequestConfig.custom().setConnectTimeout(5000).setSocketTimeout(5000)
			.setConnectionRequestTimeout(5000).build();

	public static String get(String url, Map<String, String> params) throws Exception {
		String result = null;

		List<NameValuePair> pairs = new ArrayList<>();
		for (Entry<String, String> entry : params.entrySet()) {
			pairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}
		URI uri = new URI(url + "?" + URLEncodedUtils.format(pairs, Consts.UTF_8));

		HttpGet httpGet = new HttpGet(uri);
		httpGet.setConfig(CONFIG);
		CloseableHttpClient httpClient = HttpClients.createDefault();

		CloseableHttpResponse response = httpClient.execute(httpGet);
		HttpEntity entity = response.getEntity();
		if (null != entity) {
			result = EntityUtils.toString(entity, Consts.UTF_8);
		}

		response.close();
		httpClient.close();
		httpGet.abort();
		httpGet.releaseConnection();
		return result;
	}

	public static String post(String url, Map<String, String> params) throws Exception {
		String result = null;

		HttpPost httpPost = new HttpPost(url);
		httpPost.setConfig(CONFIG);
		CloseableHttpClient httpClient = HttpClients.createDefault();

		StringEntity stringEntity = new StringEntity(JSON.toJSONString(params), Consts.UTF_8);
		stringEntity.setContentEncoding(Consts.UTF_8.toString());
		stringEntity.setContentType("application/json");
		httpPost.setEntity(stringEntity);

		CloseableHttpResponse response = httpClient.execute(httpPost);
		HttpEntity entity = response.getEntity();
		if (null != entity) {
			result = EntityUtils.toString(entity, Consts.UTF_8);
		}

		response.close();
		httpClient.close();
		httpPost.abort();
		httpPost.releaseConnection();

		return result;
	}

}