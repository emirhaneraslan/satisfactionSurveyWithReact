import DataButton from '../../components/DataButton/DataButton'
import DataInput from '../../components/DataInput/DataInput'
import Navbar from '../../components/HomeNavbar/Navbar'
import './SignUp.css'
import { useState,useRef } from 'react'
import axios from 'axios';
import {useNavigate} from 'react-router-dom'






const SignUp = () => {

    const navigate = useNavigate()

    const firstNameInput = useRef()
    const lastNameInput = useRef()
    const eMailInput = useRef()
    const passwordInput = useRef()
    const adressInput = useRef()

    const [userForm,setUserForm] = useState({
        userName: "",
        userSurname: "",
        userEmail: "",
        userPassword: "",
        userAdress: ""
      })

      const submitOnClick = () => {

        

            if(firstNameInput.current.value=="" || lastNameInput.current.value=="" || eMailInput.current.value=="" || passwordInput.current.value=="" || adressInput.current.value=="") {
                alert("Lütfen Eksiksiz Giriş Yapınız")
                return
            }else {
                submitToDataBase()
            }
  
      }

      const submitToDataBase=() =>{
        var axios = require('axios');
var data = JSON.stringify({
  "userName": userForm.userName,
  "userSurname": userForm.userSurname,
  "userEmail": userForm.userEmail,
  "userAdress": userForm.userAdress,
  "userPassword": userForm.userPassword
});

var config = {
  method: 'post',
  url: 'http://localhost:8080/api/user/save',
  headers: { 
    'Content-Type': 'application/json'
  },
  data : data
};

axios(config)
.then(function (response) {
  console.log(JSON.stringify(response.data));
  localStorage.setItem('isEntered',true)
  localStorage.setItem('user',JSON.stringify(response.data))
  navigate('/firstpage')
})
.catch(function (error) {
  console.log(error);
});
    
    }

    return(
        <>
        <div className='signup_body'>

            <Navbar></Navbar>

            <div className="container">
            <div className="signup_container">
                    <div className="row">
                        <div className="col-12 bg-light">
                        <div className="row">
                        <h1 className="text-center pt-6 mt-4 mb-3 text-center text-dark text-display-3">Sign Up</h1>
                        <div className='col'></div>
                    <div className="col-9">
                    <form>
                        <DataInput label_text={"First Name"} input_onChange={(e)=> {
                        setUserForm({...userForm, userName:e.target.value
                         })}} 
                        input_ref={firstNameInput}/>
                        <DataInput label_text={"Last Name"}
                        input_onChange={(e)=> {
                            setUserForm({...userForm, userSurname:e.target.value
                            })}} 
                        input_ref={lastNameInput}/>
                        <DataInput label_text={"E-Mail"}
                        input_onChange={(e)=> {
                            setUserForm({...userForm, userEmail:e.target.value
                            })}} 
                        input_ref={eMailInput}/>
                        <DataInput label_text={"Password"}
                        input_onChange={(e)=> {
                            setUserForm({...userForm, userPassword:e.target.value
                            })}} 
                        input_ref={passwordInput}/>
                        <DataInput label_text={"Adress"}
                        input_onChange={(e)=> {
                            setUserForm({...userForm, userAdress:e.target.value
                            })}} 
                        input_ref={adressInput}/>
                        <div className="row">
                            <div className="col-6"><DataButton button_text={"SUBMİT"} button_onClick={submitOnClick}/> </div>
                            <div className="col-6"><DataButton button_text={"SIGN IN"} button_onClick={()=>{
                                navigate('/signin')
                            }}/></div>
                        </div>
                        
                    </form>
                    </div>
                    <div className='col'></div>
                        </div>
                        </div>    
                    </div>
                </div>

            </div>

            </div>
                



        </>
    )
}

export default SignUp