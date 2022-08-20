import './App.css';



import {Routes,Route} from 'react-router-dom'
import HomeView from './view/Home/Home';
import Contact from './view/Contact/Contact';
import SurveyPage from './view/SurveyPage/SurveyPage';
import SignIn from './view/SignIn/SignIn';
import SignUp from './view/SıgnUp/SignUp';
import AdminPage from './view/AdminPage/AdminPage';
import BlogPage from './view/BlogPage/BlogPage';
import CreateSurvey from './view/CreateSurvey/CreateSurvey';
import FirstPage from './view/FirstPage/FirstPage';
import SurveyView from './view/SurveyView/SurveyView';
import SurveyAnswerView from './view/SurveyAnswerView/SurveyAnswersView';
import UserList from './view/UserList/UserList';

    
    //localStorage.setItem('isEntered',false)
   



function App() {
  
    
  
  return (
    <div>

      
      

      <Routes>
      <Route path='/' element={<HomeView/>}/>
      <Route path='/surveypage' element={<SurveyPage/>}/>
      <Route path='/contact' element={<Contact/>}/>
      <Route path='/signin' element={<SignIn/>}/>
      <Route path='/signup' element={<SignUp/>}/>
      <Route path='/admin' element={<AdminPage/>}/>
      <Route path='/createsurvey' element={<CreateSurvey/>}/>
      <Route path='/firstpage' element={<FirstPage/>}/>
      <Route path='/surveyview/:id' element={<SurveyView/>}/>
      <Route path='/surveyanswerview' element={<SurveyAnswerView/>}/>
      <Route path='/userlist' element={<UserList/>} />
      
      
      </Routes>
      
      
      
      
        
      
    </div>
  );
}

export default App;
