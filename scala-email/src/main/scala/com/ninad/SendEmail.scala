package com.ninad

import javax.mail._
import javax.mail.internet.{InternetAddress, MimeBodyPart, MimeMessage, MimeMultipart}
import java.util.Properties
import javax.activation.DataHandler
import javax.activation.FileDataSource

object SendEmail {
  def main(args: Array[String]): Unit = {
    val to = "recipient-email@example.com"
    val from = "sender-email@example.com"
    val host = "smtp.your-email-provider.com"
    val attachmentFilePath = "location/path/to/your/attachment.csv"

    // Setup properties for sending mail
    val properties = new Properties()
    properties.put("mail.smtp.auth", "true")
    properties.put("mail.smtp.starttls.enable", "true")
    properties.put("mail.smtp.host", host)
    properties.put("mail.smtp.port", "587")

    // Setup authentication
    val session = Session.getInstance(properties, new javax.mail.Authenticator() {
      override protected def getPasswordAuthentication: PasswordAuthentication = {
        new PasswordAuthentication(from, System.getenv("EMAIL_PASSWORD"))
      }
    })

    try {
      // Create a default MimeMessage object
      val message = new MimeMessage(session)

      // Set From: header field of the header
      message.setFrom(new InternetAddress(from))

      // Set To: header field of the header
      message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to))

      // Set Subject: header field
      message.setSubject("Subject of the email")

      // Create the message body
      val multipart = new MimeMultipart()
      val textPart = new MimeBodyPart()
      textPart.setText("Body of the email")

      // Attach the file
      val attachmentPart = new MimeBodyPart()
      val fileDataSource = new FileDataSource(attachmentFilePath)
      attachmentPart.setDataHandler(new DataHandler(fileDataSource))
      attachmentPart.setFileName(fileDataSource.getName)

      // Add parts to the multipart
      multipart.addBodyPart(textPart)
      multipart.addBodyPart(attachmentPart)

      // Set the content of the message
      message.setContent(multipart)

      // Send message
      Transport.send(message)

      println("Email with attachment sent successfully...")

    } catch {
      case e: MessagingException =>
        e.printStackTrace()
    }
  }
}
