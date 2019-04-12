package xin.mengzuo.moviemanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

public class Test {
	public static void main(String[] args) {
		String path = Thread.currentThread().getContextClassLoader().getResource("static").getPath();
	    System.out.println(path);
	}
	}

