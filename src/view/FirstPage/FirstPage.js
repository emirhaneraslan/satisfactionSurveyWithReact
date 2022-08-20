import Navbar from "../../components/Navbar/Navbar"
import HomeNavbar from "../../components/HomeNavbar/Navbar"
import Footer from '../../components/Footer/Footer'
import './FirstPage.css'
import Card from '../../components/Card3/Card'
import {useNavigate} from 'react-router-dom'

const FirstPage = () =>{
    const navigate = useNavigate()
    console.log(JSON.parse(localStorage.getItem('user')));

    return(
        <>
        {JSON.parse(localStorage.getItem('isEntered')) ? <Navbar/>: <HomeNavbar/>}

        <div className="firstpage-card-body">
        <div class="firstpage_card_container">
        <Card card_title={"Anket Cevaplamak İster Misiniz?"} button_text={"Daha Fazlası İçin Tıklayınız"} button_onClick={()=>{
            navigate('/surveypage')
        }}/>
        <Card card_title={"İstek veya Şikayetlerinizi Bildirmek İster Misiniz?"} button_text={"Daha Fazlası İçin Tıklayınız"} button_onClick={()=>{
            navigate('/contact')
        }}/>
        
            </div>
        </div>
        
        <Footer/>
        </>
    )
}

export default FirstPage