package com.Duitto.utility;

import com.Duitto.dto.Mail;
import com.Duitto.dto.UserDto;
import com.Duitto.model.ConfirmationTokenModel;
import com.Duitto.model.CustomerRegistrationModel;


public class MailUtils {

    public static Mail emailVerification(ConfirmationTokenModel token, String email){

        String tokenEmail = token.getConfirmationToken();
        Mail mail = new Mail();

        mail.setMailFrom("Duitto.com");
        mail.setMailTo(email);
        mail.setMailSubject("Welcome to Duitto!");
        StringBuilder body = new StringBuilder();

        body.append("<html>");
        body.append("<head>");
        body.append("<style>");
        body.append("@media screen and (max-width: 500px) {");
        body.append(".header-text" + "{" + "font-size:1.3rem !important;" + "}");
        body.append(".margin-text" + "{" + " margin: 0 2% !important;" + "}");
        body.append("}");
        body.append("</style>");
        body.append("</head>");
        body.append("<body>");
        String template = "<div style='margin:0 10%;font-family: sans-serif;' class='margin-text'>"

                + "<div style='height: 20px;background-color: #0097ef;margin: 40px 0;align-self: center;'>&nbsp;</div>"
                + "<div style='padding-left:10%;'>"
                + "<div style='border-bottom: 2px solid #a6a6b9;'><span style='font-size: 1rem;color: gray;padding-bottom: 21px;font-weight: 700;' class='header-text'>Verify Your Email\r\n" +
                "</span></div>"
                + "<p style='font-size: 1rem;color: #a6a6b9;margin-bottom:20px;margin-top: 40px;'>Hi "
                + "&#44;</p>"
                + "<p style='font-size: 1rem;color: #a6a6b9;margin-bottom:40px;'>To continue setting up your Duitto account, we need to confirm your email address. Please click on the button below to verify your email address&#46; </p>"

                + "<div style='position: relative;top: 10px;'><a href=\"http://localhost:4200/confirm/"
                + tokenEmail + "\" "
                + "style='width: max-content;color: #ffffff;background: #0097ef;border: 2px solid #0097ef;padding: 10px;border-radius: 4px;font-size: 1.2rem;text-decoration: unset;font-family: sans-serif;' ><span>Verify Email</span></a></div>"

                + "<div style='position: relative;top: 10px;margin-top: 50px;'><a href=\"http://localhost:4200/confirm/"
                + tokenEmail + "\" "
                + " ><span style='color:#000000'>Unable to click on the above button? Click here </span><span>http://localhost:4200/confirm/"+tokenEmail+"</span></a></div>"

                + "</div>"
                + "<div style='height: 20px;background-color: #0097ef;margin: 40px 0;align-self: center;'>&nbsp;</div>"
                + "</div>";
        body.append(template);
        body.append("<body>");
        body.append("</html>");
        mail.setMailContent(body.toString());

        return mail;
    }

    public static Mail emailForgotpassword(String authKey, String fullName, String to){
        Mail mail = new Mail();
        mail.setMailFrom("Duitto.com");
        mail.setMailTo(to);
        mail.setMailSubject("Forgot Password");
        StringBuilder body = new StringBuilder();
        body.append("<html>");
        body.append("<head>");
        body.append("<style>");
        body.append("@media screen and (max-width: 500px) {");
        body.append(".header-text" + "{" + "font-size:1.3rem !important;" + "}");
        body.append(".margin-text" + "{" + " margin: 0 2% !important;" + "}");
        body.append("}");
        body.append("</style>");
        body.append("</head>");
        body.append("<body>");
        String templet = "<div style='margin:0 10%;font-family: sans-serif;' class='margin-text'>"
                + "<div style='height: 20px;background-color: #0097ef;margin: 40px 0;align-self: center;'>&nbsp;</div>"
                + "<div style='padding-left:10%;'>"
                + "<div style='border-bottom: 2px solid #a6a6b9;'><span style='font-size: 3rem;color: gray;padding-bottom: 21px;' class='header-text'>Reset Your Password</span></div>"
                + "<p style='font-size: 1rem;color: #a6a6b9;margin-bottom:20px;margin-top: 40px;'>Hi " + fullName
                + "&#44;</p>"
                + "<p style='font-size: 1rem;color: #a6a6b9;margin-bottom:20px;'>We got a request to reset your password&#46; </p>"
                + "<p style='font-size: 1rem;color: #a6a6b9;margin-bottom:20px;'>Please click the button below to change your password&#46; </p>"
                + "<p style='font-size: 1rem;color: #a6a6b9;margin-bottom:20px;'>Note that this link is valid for 24 hours&#46; After the time limit has expired, you will have to resubmit the request for a password reset&#46; </p>"
                + "<div style='position: relative;top: 10px;'><a href=\"http://localhost:4200/ConfirmPassword/"
                + authKey + "\" "
                + "style='width: max-content;color: #ffffff;background: #0097ef;border: 2px solid #0097ef;padding: 10px;border-radius: 4px;font-size: 1.2rem;text-decoration: unset;font-family: sans-serif;' ><span>Change Your Password</span></a></div>"
                + "</div>"
                + "<div style='height: 20px;background-color: #0097ef;margin: 40px 0;align-self: center;'>&nbsp;</div>"
                + "</div>";
        body.append(templet);
        body.append("<body>");
        body.append("</html>");
        mail.setMailContent(body.toString());
        return mail;
    }

   /* public static Mail emailUpdateOrderStatus( String shippedDate){

        Mail mail = new Mail();
        mail.setMailFrom("mybondoo.com");
        mail.setMailTo(orderModel.getCustomer().getEmail());
        mail.setMailSubject("Your mybondoo Order status updated");
        String messageBody = "Please Check Your Order Status in details as follow";
        String titleMessage="Order Status Updated";

        StringBuilder body = new StringBuilder();

            body.append("<html>");
            body.append("<head>");
            body.append("<style>");
            body.append("@media screen and (max-width: 500px) {");
            body.append(".header-text" + "{" + "font-size:1.3rem !important;" + "}");
            body.append(".margin-text" + "{" + " margin: 0 2% !important;" + "}");
            body.append("}");
            body.append("</style>");
            body.append("</head>");
            body.append("<body>");
            String templet = "<div style='margin:0 10%;font-family: sans-serif;' class='margin-text'>"

                    + "<div style='height: 20px;background-color: #0097ef;margin: 40px 0;align-self: center;'></div>"
                    + "<div style='padding-left:10%;'>"
                    + "<div style='border-bottom: 2px solid #a6a6b9;'><span style='font-size: 1rem;color: #000000;padding-bottom: 21px;font-weight: 700;' class='header-text'>"+titleMessage+" \r\n" +
                    "</span></div>"
                    + "<p style='font-size: 1rem;color:#000000;margin-bottom:20px;margin-top: 40px;'>Hi "+orderModel.getCustomer().getFirstName()+" "
                    + "&#44;</p>"
                    + "<p style='font-size: 1rem;color: #000000;margin-bottom:40px;'>"+messageBody+"\r\n" +
                    "\r\n" +
                    "&#46; </p>"

                    + "<div style='position: relative;top: 10px;'>"

                    + "</div>"
                    + "<div style='position: relative;top: 10px;margin-top: 20x;'>"
                    + " <span style='color: gray'>Order Id : "+orderModel.getId()+" </span></div>"
                    + "<div style='position: relative;top: 10px;margin-top: 5px;'>"
                    + " <span style='color: gray'>Order Status : "+orderModel.getStatus()+" </span></div>"
                    + "<div style='position: relative;top: 10px;margin-top: 5px;'>"
                    + " <span style='color: gray'>Consignment Status : "+orderModel.getConsignmentStatus()+" </span></div>"
                    + "<div style='position: relative;top: 10px;margin-top: 5px;'>"
                    + " <span style='color: gray'>Shipped Date : "+shippedDate+" </span></div>"
                    + "<div style='position: relative;top: 10px;margin-top: 5px;'>"
                    + " <span style='color: gray'>Estimated Delivery Days : "+orderModel.getEstimatedDeliveryDays()+" </span></div>"

                    + "</div>"
                    + "<div style='height: 20px;background-color: #0097ef;margin: 40px 0;align-self: center;'>&nbsp;</div>"
                    + "</div>";
            body.append(templet);
            body.append("<body>");
            body.append("</html>");
        mail.setMailContent(body.toString());
        return mail;
    }*/

    public static Mail emailUnapproveOrderPlacementStatus(CustomerRegistrationModel customerRegistrationModel){
        Mail mail = new Mail();
        mail.setMailFrom("mybondoo.com");
        mail.setMailTo(customerRegistrationModel.getEmail());
        mail.setMailSubject("You have created an Order with status Unapproved");

        StringBuilder body = new StringBuilder();

        body.append("<html>");
        body.append("<head>");
        body.append("<style>");
        body.append("@media screen and (max-width: 500px) {");
        body.append(".header-text" + "{" + "font-size:1.3rem !important;" + "}");
        body.append(".margin-text" + "{" + " margin: 0 2% !important;" + "}");
        body.append("}");
        body.append("</style>");
        body.append("</head>");
        body.append("<body>");
        String templet = "<div style='margin:0 10%;font-family: sans-serif;' class='margin-text'>"

                + "<div style='height: 20px;background-color: #0097ef;margin: 40px 0;align-self: center;'></div>"
                + "<div style='padding-left:10%;'>"
                + "<div style='border-bottom: 2px solid #a6a6b9;'><span style='font-size: 1rem;color: gray;padding-bottom: 21px;font-weight: 700;' class='header-text'>Order is under review for approval \r\n" +
                "</span></div>"
                + "<p style='font-size: 1rem;color: #a6a6b9;margin-bottom:20px;margin-top: 40px;'>Hi "+customerRegistrationModel.getFullName()+" "
                + "&#44;</p>"
                + "<p style='font-size: 1rem;color: #a6a6b9;margin-bottom:40px;'>Your order has been successfully placed.\r\n" +
                "\r\n" +
                "&#46; </p>"

                + "<div style='position: relative;top: 10px;'>"

                + "</div>"

                + "<div style='position: relative;top: 10px;margin-top: 50px;'>"
                + " <span style='color:#000000'>Your Order is under review, you will let you as your order approve from mybondoo, check your status at your order history page of mybondoo. </span></a></div>"

                + "</div>"
                + "<div style='height: 20px;background-color: #0097ef;margin: 40px 0;align-self: center;'>&nbsp;</div>"
                + "</div>";
        body.append(templet);
        body.append("<body>");
        body.append("</html>");
        mail.setMailContent(body.toString());
        return mail;
    }
    
    public static Mail emailAtLogin( UserDto dto, String token){

     
        Mail mail = new Mail();

        mail.setMailFrom("Duitto.com");
        mail.setMailTo(dto.getEmail());
        mail.setMailSubject("Welcome to Duitto!");
        StringBuilder body = new StringBuilder();

        body.append("<html>");
        body.append("<head>");
        body.append("<style>");
        body.append("@media screen and (max-width: 500px) {");
        body.append(".header-text" + "{" + "font-size:1.3rem !important;" + "}");
        body.append(".margin-text" + "{" + " margin: 0 2% !important;" + "}");
        body.append("}");
        body.append("</style>");
        body.append("</head>");
        body.append("<body>");
        String template = "<div style='margin:0 10%;font-family: sans-serif;' class='margin-text'>"

                + "<div style='height: 20px;background-color: #0097ef;margin: 40px 0;align-self: center;'>&nbsp;</div>"
                + "<div style='padding-left:10%;'>"
                + "<div style='border-bottom: 2px solid #a6a6b9;'><span style='font-size: 1rem;color: gray;padding-bottom: 21px;font-weight: 700;' class='header-text'>Link for Login\r\n" +
                "</span></div>"
                + "<p style='font-size: 1rem;color: #a6a6b9;margin-bottom:20px;margin-top: 40px;'>Hi "
                + "&#44;</p>"
                + "<p style='font-size: 1rem;color: #a6a6b9;margin-bottom:40px;'>To Login to your Duitto account, Please click on the button below&#46; </p>"

                + "<div style='position: relative;top: 10px;'><a href=\"http://localhost:4200/confirmLogin/"
                + token + "\" "
                + "style='width: max-content;color: #ffffff;background: #0097ef;border: 2px solid #0097ef;padding: 10px;border-radius: 4px;font-size: 1.2rem;text-decoration: unset;font-family: sans-serif;' ><span>Click to Login</span></a></div>"

                + "<div style='position: relative;top: 10px;margin-top: 50px;'><a href=\"http://localhost:4200/confirmLogin/"
                + token + "\" "
                + " ><span style='color:#000000'>Unable to click on the above button? Click here </span><span>http://localhost:4200/confirmLogin/"+token+"</span></a></div>"

                + "</div>"
                + "<div style='height: 20px;background-color: #0097ef;margin: 40px 0;align-self: center;'>&nbsp;</div>"
                + "</div>";
        body.append(template);
        body.append("<body>");
        body.append("</html>");
        mail.setMailContent(body.toString());

        return mail;
    }

}

