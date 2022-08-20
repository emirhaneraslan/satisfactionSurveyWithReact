import './Home.css'
import HomeNavbar from '../../components/HomeNavbar/Navbar'
import {useNavigate} from 'react-router-dom'
const Home = () => {
    const navigate = useNavigate()
    return(
        <>
        <div className="homeview_wrapper">
        <HomeNavbar/>

    <div class="homeview_center">
    <h1 className='homeview_h1'>Welcome To Eraslan</h1>
    <h2 className='homeview_h2'>You Can Answer Our Surveys</h2>
    <div class="homeview_buttons">
    <button className='homeview_button' onClick={()=>{
        navigate('/signup')
    }}>Sign Up</button>
    <button onClick={()=>{
        navigate('/signin')
    }} class="btn2 homeview_button">Sign In</button>
    </div>
    </div>
        </div>
        
        </>
    )
}

export default Home