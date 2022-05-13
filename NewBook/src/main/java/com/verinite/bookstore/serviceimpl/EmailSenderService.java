package com.verinite.bookstore.serviceimpl;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.verinite.bookstore.entity.Registration;

@Service
public class EmailSenderService {
	@Autowired
	private JavaMailSender mailsender;
	public void sendSimpleEmil(String toEmail,String body,String subject) {
		SimpleMailMessage msg=new SimpleMailMessage();
		msg.setFrom("bookstore.verinite@gmail.com");
		msg.setTo(toEmail);
		msg.setText(body);
		msg.setSubject(subject);
		mailsender.send(msg);
	}
	public void sendEmailWityhAttachement(String toEmail,String body,String subject,File file, Registration reg,String invNo) throws MessagingException{
		MimeMessage mm=mailsender.createMimeMessage();
		MimeMessageHelper mh=new MimeMessageHelper(mm,true);
		SimpleMailMessage msg=new SimpleMailMessage();
		mh.setFrom("bookstore.verinite@gmail.com");
		mh.setTo(reg.getEmailaddress());
		 mh.setText("<!DOCTYPE html>\r\n"
	         		+ "<html>\r\n"
	         		+ "<head>\r\n"
	         		+ "  <meta charset=\"utf-8\">\r\n"
	         		+ "  <meta http-equiv=\"x-ua-compatible\" content=\"ie=edge\">\r\n"
	         		+ "  <title>Welcome Email</title>\r\n"
	         		+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
	         		+ "  <style type=\"text/css\">\r\n"
	         		+ "  @media screen {\r\n"
	         		+ "    @font-face {\r\n"
	         		+ "      font-family: 'Source Sans Pro';\r\n"
	         		+ "      font-style: normal;\r\n"
	         		+ "      font-weight: 400;\r\n"
	         		+ "      src: local('Source Sans Pro Regular'), local('SourceSansPro-Regular'), url(https://fonts.gstatic.com/s/sourcesanspro/v10/ODelI1aHBYDBqgeIAH2zlBM0YzuT7MdOe03otPbuUS0.woff) format('woff');\r\n"
	         		+ "    }\r\n"
	         		+ "    @font-face {\r\n"
	         		+ "      font-family: 'Source Sans Pro';\r\n"
	         		+ "      font-style: normal;\r\n"
	         		+ "      font-weight: 700;\r\n"
	         		+ "      src: local('Source Sans Pro Bold'), local('SourceSansPro-Bold'), url(https://fonts.gstatic.com/s/sourcesanspro/v10/toadOcfmlt9b38dHJxOBGFkQc6VGVFSmCnC_l7QZG60.woff) format('woff');\r\n"
	         		+ "    }\r\n"
	         		+ "  }\r\n"
	         		+ "  body,\r\n"
	         		+ "  table,\r\n"
	         		+ "  td,\r\n"
	         		+ "  a {\r\n"
	         		+ "    -ms-text-size-adjust: 100%; \r\n"
	         		+ "    -webkit-text-size-adjust: 100%; \r\n"
	         		+ "  }\r\n"
	         		+ "  table,\r\n"
	         		+ "  td {\r\n"
	         		+ "    mso-table-rspace: 0pt;\r\n"
	         		+ "    mso-table-lspace: 0pt;\r\n"
	         		+ "  }\r\n"
	         		+ "  img {\r\n"
	         		+ "    -ms-interpolation-mode: bicubic;\r\n"
	         		+ "  }\r\n"
	         		+ "  a[x-apple-data-detectors] {\r\n"
	         		+ "    font-family: inherit !important;\r\n"
	         		+ "    font-size: inherit !important;\r\n"
	         		+ "    font-weight: inherit !important;\r\n"
	         		+ "    line-height: inherit !important;\r\n"
	         		+ "    color: inherit !important;\r\n"
	         		+ "    text-decoration: none !important;\r\n"
	         		+ "  }\r\n"
	         		+ "  div[style*=\"margin: 16px 0;\"] {\r\n"
	         		+ "    margin: 0 !important;\r\n"
	         		+ "  }\r\n"
	         		+ "  body {\r\n"
	         		+ "    width: 100% !important;\r\n"
	         		+ "    height: 100% !important;\r\n"
	         		+ "    padding: 0 !important;\r\n"
	         		+ "    margin: 0 !important;\r\n"
	         		+ "  }\r\n"
	         		+ "  table {\r\n"
	         		+ "    border-collapse: collapse !important;\r\n"
	         		+ "  }\r\n"
	         		+ "  a {\r\n"
	         		+ "    color: black;\r\n"
	         		+ "  }\r\n"
	         		+ "  img {\r\n"
	         		+ "    height: auto;\r\n"
	         		+ "    line-height: 100%;\r\n"
	         		+ "    text-decoration: none;\r\n"
	         		+ "    border: 0;\r\n"
	         		+ "    outline: none;\r\n"
	         		+ "  }\r\n"
	         		+ "  </style>\r\n"
	         		+ "</head>\r\n"
	         		+ "<body style=\"background-color: #e9ecef;\">\r\n"
	         		+ "  <div class=\"preheader\" style=\"display: none; max-width: 0; max-height: 0; overflow: hidden; font-size: 1px; line-height: 1px; color: #fff; opacity: 0;\">\r\n"
	         		+ "    A preheader is the short summary text that follows the subject line when an email is viewed in the inbox.\r\n"
	         		+ "  </div>\r\n"
	         		+ "  <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n"
	         		+ "    <tr>\r\n"
	         		+ "      <td align=\"center\" bgcolor=\"#e9ecef\">\r\n"
	         		+ "      </td>\r\n"
	         		+ "    </tr>\r\n"
	         		+ "    <tr>\r\n"
	         		+ "      <td align=\"center\" bgcolor=\"#e9ecef\">\r\n"
	         		+ "        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">\r\n"
	         		+ "          <tr>\r\n"
	         		+ "            <td bgcolor=\"#ffffff\" align=\"left\">\r\n"
	         		+ "                <h1  class=\"logo-text\" style=\" color: rgb(52,58,64);margin-left: 20%; text-align: center; font-size: 70px; width: 100%; max-width: 300px\"> Book<span style=\"color: rgb(52,152,219);\">Store</span> </h1>\r\n"
	         		+ "            </td>\r\n"
	         		+ "          </tr>\r\n"
	         		+ "        </table>\r\n"
	         		+ "      </td>\r\n"
	         		+ "    </tr>\r\n"
	         		+ "    <tr>\r\n"
	         		+ "      <td align=\"center\" bgcolor=\"#e9ecef\">\r\n"
	         		+ "        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">\r\n"
	         		+ "          <tr>\r\n"
	         		+ "            <td bgcolor=\"#ffffff\" align=\"left\" style=\"padding: 24px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 16px; line-height: 24px;\">\r\n"
	         		+ "              <h1 style=\"margin: 0 0 12px; font-size: 32px; font-weight: 400; line-height: 48px;\">Hello , "+reg.getUserName()+"</h1>\r\n"
	         		+ "              <p style=\"margin: 0;\">Thank you for Purchasing from <a href=\"http://localhost:4200\">Bookstore.verinite.com</a> .We are very glad to inform that your order is placed with the invoice number: <b>" +invNo+"</b> <br>\r\n"
	         		+ "               <br> .For any queries feel free to get in touch with us.  </p>\r\n"
	         		+ "            </td>\r\n"
	         		+ "          </tr>\r\n"
	         		+ "          <tr>\r\n"
	         		+ "            <td align=\"left\" bgcolor=\"#ffffff\">\r\n"
	         		+ "              <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n"
	         		+ "                <tr>\r\n"
	         		+ "                  <td align=\"center\" bgcolor=\"#ffffff\" style=\"padding: 12px;\">\r\n"
	         		+ "                    <!-- <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n"
	         		+ "                      <tr>\r\n"
	         		+ "                        <td align=\"center\" bgcolor=\"#1a82e2\" style=\"border-radius: 6px;\">\r\n"
	         		+ "                          <a href=\"https://sendgrid.com\" target=\"_blank\" rel=\"noopener noreferrer\" style=\"display: inline-block; padding: 16px 36px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 16px; color: #ffffff; text-decoration: none; border-radius: 6px;\">Do Something Sweet</a>\r\n"
	         		+ "                        </td>\r\n"
	         		+ "                      </tr>\r\n"
	         		+ "                    </table> -->\r\n"
	         		+ "                  </td>\r\n"
	         		+ "                </tr>\r\n"
	         		+ "              </table>\r\n"
	         		+ "            </td>\r\n"
	         		+ "          </tr>\r\n"
	         		+ "          <tr>\r\n"
	         		+ "            <td align=\"left\" bgcolor=\"#ffffff\" style=\"padding: 24px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 16px; line-height: 24px; border-bottom: 3px solid #d4dadf\">\r\n"
	         		+ "              <p style=\"margin: 0;\">Thanks & Regards,<br> <b>Team BookStore</b></p>\r\n"
	         		+ "            </td>\r\n"
	         		+ "          </tr>\r\n"
	         		+ "        </table>\r\n"
	         		+ "      </td>\r\n"
	         		+ "    </tr>\r\n"
	         		+ "    <tr>\r\n"
	         		+ "      <td align=\"center\" bgcolor=\"#e9ecef\" style=\"padding: 24px;\">\r\n"
	         		+ "        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">\r\n"
	         		+ "          <tr>\r\n"
	         		+ "            <td align=\"center\" bgcolor=\"#e9ecef\" style=\"padding: 12px 24px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 20px; color: #666;\">\r\n"
	         		+ "              <p style=\"margin: 0;\">You received this email because we received a request for Recipt of your recent Purchase from Bookstore.Verinite.com. If you didn't make any request kindly report at  <a href=\"mailto:bookstore.verinite@gmail.com\">BookStore.verinite@support.com</a> </p>\r\n"
	         		+ "            </td>\r\n"
	         		+ "          </tr>\r\n"
	         		+ "          <tr>\r\n"
	         		+ "            <td align=\"center\" bgcolor=\"#e9ecef\" style=\"padding: 12px 24px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 20px; color: #666;\">\r\n"
	         		+ "              <p style=\"margin: 0;\">To Buy more books , you can visit <a href=\"https://localhost:4200\" target=\"_blank\" rel=\"noopener noreferrer\">Bookstore.verinite.com</a> at any time.</p>\r\n"
	         		+ "            </td>\r\n"
	         		+ "          </tr>\r\n"
	         		+ "        </table>\r\n"
	         		+ "      </td>\r\n"
	         		+ "    </tr>\r\n"
	         		+ "  </table>\r\n"
	         		+ "</body>\r\n"
	         		+ "</html>", true);

		
		mh.setSubject(subject);
		FileSystemResource fileSystem=new FileSystemResource(file);
		mh.addAttachment(fileSystem.getFilename(),fileSystem);
		mailsender.send(mm);
	}

}
