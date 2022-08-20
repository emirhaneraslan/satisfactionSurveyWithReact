import DataButton from '../../components/DataButton/DataButton'
import DataInput from '../../components/DataInput/DataInput'
import Navbar from '../../components/HomeNavbar/Navbar'
import './SignIn.css'
import { useState,useRef,useEffect } from 'react'
import {useNavigate} from 'react-router-dom'


const SignIn = () => {

    const navigate = useNavigate()

    const eMailInput = useRef()
    const passwordInput = useRef() 

    const [user,setUser] = useState({});

    

      const buttonOnClick = () => {

        if(eMailInput.current.value=="" || passwordInput.current.value=="") {
            alert("Lütfen Boş Alanları Doldurunuz...")
            return
        }else {
        var axios = require('axios');

        var config = {
            method: 'get',
            url: `http://localhost:8080/api/user/findbyemail/${eMailInput.current.value}`,
            headers: { }
        };
    
            axios(config)
            .then( (response)=> {
                console.log(response);
            setUser(response.data)
            })
            .catch((error)=> {
                console.log(error);
                
            });

            
        }
        

           
            

      }

      useEffect(()=> {
            if (user.userEmail==eMailInput.current.value && user.userPassword==passwordInput.current.value && user.active==true) {
                localStorage.setItem('isEntered',true)
                localStorage.setItem('user',JSON.stringify(user))
                alert("Giriş Başarılı")
                navigate('/firstpage')
            }else if (user.active==false) {
                alert("Artık Aktif Değilsiniz")
            } 
      },[user])

      const logInControl = () => {
            
      }

    
    return(
        <>
        <div className='sigin_body'>
            
        <Navbar></Navbar>
        

        

        <div className="container">
        <div className='signin_container'>
                    <div className="row">
                        <div className="col-12 bg-light">
                        <div className="row">
                        <h1 className="text-center pt-6 mt-4 mb-3 text-center text-dark text-display-3">Sign In</h1>
                        <div className='col'></div>
                    <div className="col-9">
                    <form>
                        <DataInput label_text={"E-Mail"}
                        input_ref={eMailInput}/>
                        <DataInput label_text={"Password"}
                        input_ref={passwordInput}/>
                        <div className="row">
                            <div className="col-6"><DataButton button_text={"LOG IN"}
                            button_onClick={buttonOnClick}/> </div>
                            <div className="col-6"><DataButton button_text={"SIGN UP"} button_onClick={()=>{
                                navigate('/signup')
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

export default SignIn