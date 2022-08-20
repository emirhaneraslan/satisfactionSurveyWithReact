import { useRef } from "react"
import Footer from "../../components/FixedFooter/Footer"
import Navbar from "../../components/Navbar/Navbar"
import HomeNavbar from "../../components/HomeNavbar/Navbar"
import './Contact.css'

const Contact = () => {

		
	  

	const name = useRef("");
	const email = useRef("");
	const phone = useRef("");
	const message = useRef("");

const buttonOnClick = () =>{

	

	var axios = require('axios');
	var data = JSON.stringify({
  		"to": `${email.current.value}`,
  		"subject":  `${message.current.value}`,
  		"message": `Sayın ${name.current.value}, \nİlgili Konu Hakkında Geri Dönüş Sağlayacağız`
	});

	var config = {
  	method: 'post',
  	url: 'http://localhost:8080/send-email',
  	headers: { 
    'Content-Type': 'application/json'
  	},
  	data : data
	};

		axios(config)
		.then(function (response) {
  		console.log(JSON.stringify(response.data));
		email.current.value=""
		name.current.value=""
		phone.current.value=""
		message.current.value=""
		})
		.catch(function (error) {
  		console.log(error);
		});

}
    return(
        <>
		
		{JSON.parse(localStorage.getItem('isEntered')) ? <Navbar/>: <HomeNavbar/>}
        

        <div className="contact_container">
		<div className="contact-box">
			<div className="contact_left"></div>
			<div className="contact_right">
				
				<h2 className="contact_h2">Contact Us</h2>
				<input ref={name} type="text" className="contact_field" placeholder="Your Name"/>
				<input ref={email} type="text" className="contact_field" placeholder="Your Email"/>
				<input ref={phone} type="text" className="contact_field" placeholder="Phone"/>
				<textarea ref={message} placeholder="Message" className="contact_field"></textarea>
				<button onClick={buttonOnClick} className="contact_btn">Send</button>
				
				
			</div>
		</div>
	</div>
        <Footer/>
        </>
    )
}

export default Contact