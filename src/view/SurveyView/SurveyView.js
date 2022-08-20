import Navbar from "../../components/Navbar/Navbar"
import HomeNavbar from "../../components/HomeNavbar/Navbar"
import TwoOptions from '../../components/TwoOptions/TwoOptions'
import ThreeOptions from '../../components/ThreeOptions/ThreeOptions'
import FiveOptions from '../../components/FiveOptions/FiveOptions'
import DataButton from '../../components/DataButton/DataButton'
import './SurveyView.css'
import React,{ useEffect, useState } from 'react';
import {useParams} from 'react-router-dom'
import {useNavigate} from 'react-router-dom'

const answers = new Map();
const SurveyView = () => {

    const navigate = useNavigate()

    const {id} = useParams()

    const [questions,setQuestions] = useState([])

    useEffect(()=> {
        answers.clear()
      },[])

    useEffect(()=> {
        var axios = require('axios');

        var config = {
        method: 'get',
        url: `http://localhost:8080/api/question/getbysurveyid/${id}`,
        headers: { }
        };

        axios(config)
        .then(function (response) {
        setQuestions(response.data)
        console.log(questions);
        })
        .catch(function (error) {
        console.log(error);
        });

      },[])
      useEffect(()=> {
        
      },[questions])

      const optionOnChange = (e) => {
        answers.set(`${e.target.name}`,`${e.target.value}`)
        console.log(e.target.value);
        console.log(e.target.name);
        console.log(answers);
        console.log(answers.size);
        console.log(questions);

        
        
      }
    return(
        <>
        {JSON.parse(localStorage.getItem('isEntered')) ? <Navbar/>: <HomeNavbar/>}
        
        

        <div className="container-survey-view">
            <div className="row">
                <div className="col"></div>
                <div className="surveyview-container-center col-11">
                    <div>
                    <h1 className='surveyview-survey-title'>Student Survey</h1>
                    <hr/>
                    </div>

                    <form className='survey-question'>
                        <div className="container">
                            <div className="row">
                                <div className="col"></div>
                                <div className="col-10">
                                    {questions.map((item,i)=>{
                                        if(item.questionType.questionTypeId==3) {
                                            return(
                                                <>
                                                <FiveOptions optionOnChange={optionOnChange} key={i} question={item.question} name={item.questionId}
                                                html_for1={`fiveoption5_1_${i}`}
                                                html_for2={`fiveoption5_2_${i}`}
                                                html_for3={`fiveoption5_3_${i}`}
                                                html_for4={`fiveoption5_4_${i}`}
                                                html_for5={`fiveoption5_5_${i}`}
                                                />
                                                </>
                                            )
                                        }else if(item.questionType.questionTypeId==2) {
                                            return(
                                                <>
                                                <ThreeOptions optionOnChange={optionOnChange} key={i} question={item.question} name={`fiveoption3_${i}`}
                                                html_for1={`fiveoption3_1_${i}`}
                                                html_for2={`fiveoption3_2_${i}`}
                                                html_for3={`fiveoption3_3_${i}`}
                                                />
                                                </>
                                            )
                                        }else if(item.questionType.questionTypeId==1) {
                                            return(
                                                <>
                                                <TwoOptions optionOnChange={optionOnChange} key={i} question={item.question} name={item.questionId}
                                                html_for1={`fiveoption2_1_${i}`}
                                                html_for2={`fiveoption2_2_${i}`}
                                                />
                                                </>
                                            )
                                        }
                                    })}
                                </div>
                                <div className="col"></div>
                            </div>
                        </div>
                        <div className="row">
                            <div className="col"></div>
                            <div className="col-10">
                                <DataButton button_text={"SUBMİT"} button_onClick={()=>{
                                    if(questions.length !=answers.size) {
                                        alert("Lütfen Boş Sorularıda Cevaplayınız")
                                    }else {
                                        alert("Anket Başarılı Şekilde Kayıt Edildi")

                                        {

                                            questions.map((item,i)=>{


                                                console.log(answers.get(`${item.questionId}`));
                                            
                                            var axios = require('axios');
                                            var data = JSON.stringify({
                                            "answer": `${answers.get(`${item.questionId}`)}`,
                                            "questionId": parseInt(item.questionId),
                                            "userId": (JSON.parse(localStorage.getItem('user'))).userId
                                            });

                                            var config = {
                                            method: 'post',
                                            url: 'http://localhost:8080/api/answer/save',
                                            headers: { 
                                            'Content-Type': 'application/json'
                                            },
                                            data : data
                                            };

                                            axios(config)
                                            .then(function (response) {
                                                console.log(JSON.stringify(response.data));
                                                navigate('/surveyanswerview',{state:{answers}})
                                                
                                            })
                                            .catch(function (error) {
                                                console.log(error);
                                            });
                                            })
                                            
                                        }
                                    }
                                }}/>
                            </div>
                            <div className="col"></div>
                        </div>
                    </form>


                </div>
                <div className="col"></div>
            </div>
        </div>
        
        </>
    )
}

export default SurveyView