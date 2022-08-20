import './AdminPage.css'
import AdminNavbar from '../../components/AdminNavbar/Navbar'
import Card from '../../components/Card3/Card'
import {useNavigate} from 'react-router-dom'

const AdminPage = () => {
    const navigate = useNavigate()
    return(
        <>
        <AdminNavbar/>

        <div className="adminpage-card-body">
        <div class="adminpage_card_container">
        <Card card_title={"USER MANAGEMENT SYSTEM"} button_text={"CLİCK TO GO"}  button_onClick={()=>{
            navigate('/userlist')
        }}/>
        
        <Card card_title={"CREATE SURVEY"} button_text={"CLİCK TO GO"} button_onClick={()=>{
            navigate('/createsurvey')
        }}/>
            </div>
        </div>
        
        </>
    )
}

export default AdminPage