package com.verinite.bookstore.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.verinite.bookstore.entity.Invoice;
import com.verinite.bookstore.entity.PdfEntity;
import com.verinite.bookstore.entity.Registration;
import com.verinite.bookstore.repository.InvoiceRepo;
import com.verinite.bookstore.serviceimpl.EmailSenderService;
import com.verinite.bookstore.serviceimpl.InvoiceImpl;
import com.verinite.bookstore.serviceimpl.RegistrationServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class InvoiceController {
	@Autowired
	InvoiceRepo repo;
	@Autowired
	InvoiceImpl generateInvoice;

	@PostMapping("/saveinvoice/{id}/{amount}")
	Invoice saveInvoice(@PathVariable int id,@PathVariable double amount, @RequestBody Invoice delivery) {
		delivery.setPaymentId(id);
		delivery.setAmount(amount);

		return repo.save(delivery);
	}
	@Autowired
	private EmailSenderService es;
	@Autowired
	private RegistrationServiceImpl rs;
	String invo;
	@Transactional
	@GetMapping("/generateInvoice/{username}/{paymentid}")
	@Produces(MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<Object> getInvoiceDetails(@PathVariable String username, @PathVariable int paymentid)
			throws FileNotFoundException, MessagingException {
		List<Map<String, String>> mapitems = repo.getAllDataOfInvoice(username, paymentid);
		List<PdfEntity> list = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		mapitems.forEach(a -> {
			PdfEntity pdfEntity = mapper.convertValue(a, PdfEntity.class);
			list.add(pdfEntity);
			invo="BSINV"+pdfEntity.getInvoice_id();
		});

		InvoiceImpl generateInvoice = new InvoiceImpl();
		Invoice a = generateInvoice.createPDF(list, username);
		File file = new File("GeneratedInvoice/BSINV" + paymentid + " " + username.toUpperCase() + ".pdf");

	 

		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers).contentLength(file.length())
				.contentType(MediaType.parseMediaType("application/pdf")).body(resource);
        Registration reg=rs.getByUsername1(username);
		es.sendEmailWityhAttachement("dpavithra246@gmail.com","Please find below attachment","Invoce Details",file,reg,invo);
		return responseEntity;
	}
	@GetMapping("/frontEndInvoice/{username}/{paymentid}")
	public List<PdfEntity> getInvoiceData(@PathVariable String username, @PathVariable int paymentid) 
	{
		List<PdfEntity> list = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		List<Map<String, String>> mapitems = repo.getAllDataOfInvoice(username, paymentid);
		mapitems.forEach(a -> {
			PdfEntity pdfEntity = mapper.convertValue(a, PdfEntity.class);
			list.add(pdfEntity);
		});
		System.out.println("Front end invoice");
		return list;
		

	}
}
