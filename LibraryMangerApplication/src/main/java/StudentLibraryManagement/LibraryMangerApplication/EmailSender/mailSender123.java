package StudentLibraryManagement.LibraryMangerApplication.EmailSender;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
//import java.util.logging.Logger;

@Component
public class mailSender123{
    @Autowired
    private JavaMailSender javaMailSender;
    private static final Logger logs= LoggerFactory.getLogger(mailSender123.class);
    public  boolean IsMailSend(String mailTo, String sub, String Body){
        try {
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo(mailTo);
            mail.setSubject(sub);
            mail.setText(Body);
            mail.setFrom("springprojectcrickbuzz@gmail.com");
            javaMailSender.send(mail);
        }catch (Exception e){
            logs.info(e.getMessage());
            return false;
        }
        return true;
    }
}
