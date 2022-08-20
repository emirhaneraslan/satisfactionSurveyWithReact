import Card from '../../components/Card/Card'
import Footer from '../../components/Footer/Footer'
import Navbar from "../../components/Navbar/Navbar"
import HomeNavbar from "../../components/HomeNavbar/Navbar"
import './SurveyPage.css'
import {useNavigate} from 'react-router-dom'


import {useEffect} from 'react'
import { useState } from 'react'



const SurveyPage = () => {

  const navigate = useNavigate()

    const [surveys,setSurveys] = useState([])

    useEffect(()=> {
        var axios = require('axios');
        var data = '{\r\n    "surveyName": "xxxxxx"\r\n}';
        
        var config = {
          method: 'get',
          url: 'http://localhost:8080/api/survey/findAll',
          headers: { 
            'Content-Type': 'text/plain'
          },
          data : data
        };
        
        axios(config)
        .then(function (response) {
          //console.log(((response.data))[0]);
          setSurveys(response.data)
        })
        .catch(function (error) {
          console.log(error);
        });
        

      },[])
    return(
        <>
        {JSON.parse(localStorage.getItem('isEntered')) ? <Navbar/>: <HomeNavbar/>}
        <div className="container">
            <div className="row">
                {surveys.map((item,i)=>{
                  console.log(item);
                  return(
                    <>
                    <Card card_title={item.surveyName} button_onClick={()=>{
                      if(JSON.parse(localStorage.getItem('isEntered'))==true){
                        navigate(`/surveyview/${item.surveyId}`)
                      }else {
                        alert("Öncelikle Giriş Yapmanız Gerekiyor")
                      }
                      
                    }}/>
                    </>
                  )
                })}
                
                
            </div>
        </div>
        <Footer/>
        </>
    )
}

export default SurveyPage