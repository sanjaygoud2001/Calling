package com.harman.Controller;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Service
@RestController
public class CommenController {

	@RequestMapping("/hello1")
	@Scheduled(fixedRate = 10000)
	@Async
	public String Avengers()
	{
		String uri="http://www.mocky.io/v2/5ecfd5dc3200006200e3d64b";
		RestTemplate restTemplate=new RestTemplate();
		String result=restTemplate.getForObject(uri, String.class);
		result="<body style=\"background:#ADADAD\">"+result+"</body>";
		return result;
	}
	
	
	@RequestMapping("/hello2")
	@Scheduled(fixedRate = 10000)
	@Async
	public String antiHeros()
	{
		String uri="http://www.mocky.io/v2/5ecfd630320000f1aee3d64d";
		RestTemplate restTemplate=new RestTemplate();
		String result=restTemplate.getForObject(uri, String.class);
		result="<body style=\"background:#ADADAD\">"+result+"</body>";
		return result;
	}
	
	
	@RequestMapping("/hello3")
	@Scheduled(fixedRate = 10000)
	@Async
	public String Mutents()
	{
		String uri="http://www.mocky.io/v2/5ecfd6473200009dc1e3d64e";
		RestTemplate restTemplate=new RestTemplate();
		String result=restTemplate.getForObject(uri, String.class);
		result="<body style=\"background:#ADADAD\">"+result+"</body>";
		return result;
	}
	
	
	@RequestMapping("/Calling")
	@Scheduled(fixedRate = 10000)
	@Async
	public String DynamicCalling()
	{
		RestTemplate restTemplate=new RestTemplate();
		
		String uri1="http://www.mocky.io/v2/5ecfd5dc3200006200e3d64b";
		String Avengers=restTemplate.getForObject(uri1, String.class);
		
		String uri2="http://www.mocky.io/v2/5ecfd630320000f1aee3d64d";
		String AntiHeros=restTemplate.getForObject(uri2, String.class);
		
		String uri3="http://www.mocky.io/v2/5ecfd6473200009dc1e3d64e";
		String Mutents=restTemplate.getForObject(uri3, String.class);
		
		String result1="";
		result1=result1+"<body style=\"background:#ADADAD\">"+Avengers+"</br></br>"+AntiHeros+"</br></br>"+Mutents+"</br></body>";
		return result1;
	}
	
	@RequestMapping("/ParllellCalling")
	@Scheduled(fixedRate = 10000)
	@Async
	public String parllellCalling()
	{
		RestTemplate restTemplate=new RestTemplate();
		
		ResponseEntity<String>  Avengers=restTemplate.exchange("http://www.mocky.io/v2/5ecfd5dc3200006200e3d64b",HttpMethod.GET,null,String.class);
		ResponseEntity<String>  AntiHeros=restTemplate.exchange("http://www.mocky.io/v2/5ecfd630320000f1aee3d64d",HttpMethod.GET,null,String.class);
		ResponseEntity<String>  Mutents=restTemplate.exchange("http://www.mocky.io/v2/5ecfd6473200009dc1e3d64e",HttpMethod.GET,null,String.class);
		
		
		String result1="";
		result1=result1+"<body style=\"background:#ADADAD\">"+Avengers.getBody()+"</br></br>"+AntiHeros.getBody()+"</br></br>"+Mutents.getBody()+"</br></body>";
		return result1;
	}
}
