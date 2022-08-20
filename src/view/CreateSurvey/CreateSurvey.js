import Navbar from '../../components/AdminNavbar/Navbar'
import QuestionInput from '../../components/QuestionInput/QuestionInput'
import { useRef, useState,useEffect } from 'react'
import DataButton from '../../components/DataButton/DataButton'
import DataInput from '../../components/DataInput/DataInput'
import {useNavigate} from 'react-router-dom'

import './CreateSurvey.css'

let questionType1 = []
let questionType2 = []
let questionType3 = []

const CreateSurvey = () => {
    const navigate = useNavigate()

    const arr = []

    
    

    const select = useRef("")
    const itemsRef=useRef([])
    const topicRef=useRef("")
    const selectRef=useRef([])
    
    
    const [selectNo,setSelectNo] = useState(0)
    const [questionNo,setQuestionNo] = useState(arr)
    const [surveyId,setSurveyId] = useState(0)
    const [survey,setSurvey] = useState({})
    const [option,setOption] = useState([])
    const [questionType1,setQuestionType1] = useState([])
    

    useEffect(()=> {
        var axios = require('axios');

        var config = {
        method: 'get',
        url: 'http://localhost:8080/api/questiontype/findAll',
        headers: { }
        };

        axios(config)
        .then(function (response) {
        setOption(response.data)
        })
        .catch(function (error) {
        console.log(error);
        });

        },[])

    useEffect(()=> {   
        
        questionType1.splice(0)
         
        for (let index = 0; index <selectNo; index++) {
           arr[index]=index
           questionType1[index]=1
           
        }

        if(questionType2.length==0) {
            for(let index=0;index<questionType1.length;index++) {
                questionType2[index]=1
            }
        }else if (questionType1.length < questionType2.length) {
            questionType2.length=questionType1.length
        }else if(questionType1.length > questionType2.length) {
            for (let a=questionType2.length; a<questionType1.length ;a++) {
                questionType2[a]=1;
            }
        }
        console.log(questionType2);
        
        setQuestionNo(arr)
      },[selectNo])

     const inputOnChange = () => {
        
     }

     useEffect(() => {
        questionNo.forEach(num=>{
            
            var axios = require('axios');
            var data = JSON.stringify({
              "question": `${itemsRef.current[num].value}`,
              "surveyId": surveyId,
              "questionTypeId": questionType2[num]
            });
            
            var config = {
              method: 'post',
              url: 'http://localhost:8080/api/question/save',
              headers: { 
                'Content-Type': 'application/json'
              },
              data : data
            };
            
            axios(config)
            .then(function (response) {
              console.log(JSON.stringify(response.data));
              navigate('/surveypage')
            })
            .catch(function (error) {
              console.log(error);
            });
            })
      },[surveyId]);


     const questionSubmit = ()=> {
        
     }

     const buttonOnClick = () => {
        console.log(selectRef);
        
        let isEmpty=false;
        questionNo.forEach(num=>{
            
            if(itemsRef.current[num].value=="" || topicRef.current.value==""){
                isEmpty=true                
            }
        })
        
        if(isEmpty) {
            alert("Boş Alanları Doldurunuz")
        }else {
            
            { //Başlığı Kayıt Etme
                
                var axios = require('axios');
                var data = JSON.stringify({
                "surveyName": `${topicRef.current.value}`
                });

                var config = {
                method: 'post',
                url: 'http://localhost:8080/api/survey/save',
                headers: { 
                'Content-Type': 'application/json'
                },
                data : data
                };

                axios(config)
                .then(function (response) {
                    console.log(survey);
                setSurvey((response.data))
                setSurveyId(response.data.surveyId);
                console.log(survey);
                questionSubmit()
                
                })
                .catch(function (error) {
                console.log(error);
                });

            }

            { //Soruları Kayıt Etme
                
                
                
            }

            
        }
     }
    return(
        <>
        <Navbar/>

<br/>
<br />
        


        <div className='container mb-5'>
            <div className="row">
                <div className="col"></div>
                
                <div className="col-6">
                    <h2>Choose a number question</h2>
                </div>
                <div className="col-3">
        <div className="createsurvey_div_select">
            <select className='createsurvey_select' onClick={()=> {
                    setSelectNo(select.current.value)
                    
            }} ref={select} name="format" id="format">
                <option selected disabled>Please Choose</option>
                
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
            </select>
        </div>
                </div>
                
                <div className="col"></div>
            </div>
        </div>

        

        <div className="container">
            <div className="row">
                <div className="col-1">

                </div>
                <div className="col-10">
                <form>

                <div className="container mt-5 mb-5">
            <div className="row">
                <div className="col"></div>
                <div className="col-10">
                    <DataInput label_text={"Write Survey Title"} input_ref ={topicRef}/>
                </div>
                <div className="col"></div>
            </div>
            </div>
                    
                     {questionNo.map((item,i)=>{
                        return(
                            <>
                            <QuestionInput key={i} label_text={`Write Question`} input_ref={el=>itemsRef.current[i]=el} 
                            option1_text={option[0].questionType}
                            option2_text={option[1].questionType}
                            option3_text={option[2].questionType}
                            select_ref={selectRef}
                            selectOnClick={(e)=> {
                                console.log(i);
                                console.log((i+1)+": "+e.target.value);
                                
                                if(questionType1.length > questionType2.length) {
                                    for (let a=questionType2.length; a<questionType1.length ;a++) {
                                        questionType2[a]=1;
                                    }
                                }else if (questionType1.length == questionType2.length) {
                                    questionType2[i]=parseInt(e.target.value)
                                } else if (questionType1.length < questionType2.length) {
                                    questionType2.length=questionType1.length
                                }

                                console.log(questionType2);

                                
                                   
                        }}
                            input_onChange={inputOnChange}/>
                            </>
                        )
                     })}
                    <div className="row">
                <div className="col"></div>
                <div className="col-9">
                    <DataButton button_text={"submit"} button_onClick={buttonOnClick}/>
                </div>
                <div className="col"></div>
            </div>
                </form>
                </div>
                <div className="col-1">

                </div>
            </div>
            
        </div>


        </>
    )
}

export default CreateSurvey
