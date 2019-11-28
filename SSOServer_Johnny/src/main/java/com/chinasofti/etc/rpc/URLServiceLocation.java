package com.chinasofti.etc.rpc;

import java.net.MalformedURLException;
import java.net.URL;

public class URLServiceLocation {

	private String serviceURL;
	private URL url;
	private int defaultPort;

	public URLServiceLocation(String serviceURL, String protocol,
			int defaultPort) throws MalformedURLException {
		if (!serviceURL.startsWith(protocol + "://")) {
			throw new RuntimeException("�������URLЭ����󣡣�Э��Ӧ����Ӧ����"+protocol);
		}
		this.defaultPort = defaultPort;
		this.serviceURL = "http"
				+ serviceURL.trim().substring(protocol.length());
		url = new URL(this.serviceURL);

	}

	public int getServerPort() {
		return url.getPort() == -1 ? defaultPort : url.getPort();
	}

	public String getBindOrLookupPath() {
		return url.getPath().substring(1);
	}

	public String getServerHost() {
		return url.getHost();
	}

	public String getUsername() {
		return url.getUserInfo().split(":")[0];
	}

	public String getUserpass() {
		return url.getUserInfo().split(":")[1];
	}

	/**
	 * @param args
	 * @throws MalformedURLException
	 */
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		URLServiceLocation ul = new URLServiceLocation(
				"rpc://test:test@127.0.0.1/Hello", "rpc", 1689);
		System.out.println(ul.getBindOrLookupPath());
		System.out.println(ul.getServerHost());
		System.out.println(ul.getServerPort());
		System.out.println(ul.getUsername());
		System.out.println(ul.getUserpass());
	}

}
