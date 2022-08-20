import './SurveyAnswerView.css'
import {useLocation} from 'react-router-dom'
import Navbar from '../../components/Navbar/Navbar'
import { useState } from 'react'
import { useEffect } from 'react'

const question = [];

const SurveyAnswerView = () => {

    const [theArray,setTheArray] = useState([])
/*
console.log([...answers][0][0] + "_" + [...answers][0][1])
        console.log([...answers][1][0] + "_" + [...answers][1][1])
        console.log([...answers][2][0] + "_" + [...answers][2][1]) */
    const location = useLocation()

    useEffect(()=> {
        while (question.length>0) {
            question.pop()
        }
        
        console.log([...location.state.answers][0][0]);
        for(let i =0 ; i<location.state.answers.size;i++) {
            var axios = require('axios');

        var config = {
        method: 'get',
        url: `http://localhost:8080/api/question/getbyid/${[...location.state.answers][i][0]}`,
        headers: { }
        };

        axios(config)
        .then(function (response) {
        console.log(JSON.stringify(response.data));
        question.push(response.data.question)
        console.log(question);
        setTheArray(theArray => [...theArray, response.data.question])
        console.log(theArray);
        })
        .catch(function (error) {
        console.log(error);
        });

        }
        
    },[])

    
    
    return(
        
        <>
        <Navbar/>

        
        <div>
            
                <div className="container">
                    <div className="row">
                        <div className="col"></div>
                        <div className="col-9">
                            <h2 className='surveyanswer_h2'>SAYIN {JSON.parse(localStorage.getItem('user')).userName}</h2>
                        </div>
                        <div className="col"></div>
                    </div>
                    <div className="row">
                        <div className="col"></div>
                        <div className="col-9">
<table class="table_answer">
     <thead className='thead_answer'>
     	<tr>
        
     	 <th>QUESTİON</th>
     	 <th>ANSWER</th>
     	 
     	</tr>
     </thead>
     <tbody>
     {[...location.state.answers].map((item,id)=>{
                return(<>
                <tr>
     	  	    <td data-label="S.No">{question[id]}</td>
     	  	    <td data-label="Name">{[...location.state.answers][id][1]}</td> 	  	  
     	  </tr>
                </>)
            })}
     </tbody>
   </table>
                        </div>
                        <div className="col"></div>
                    </div>
                </div>

                        
            
            
            
        </div>
        
        

        </>
    )
}

export default SurveyAnswerView