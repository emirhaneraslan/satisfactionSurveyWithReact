import Card from '../../components/Card2/Card'
import Footer from '../../components/Footer/Footer'
import Navbar from '../../components/Navbar/Navbar'
import './BlogPage.css'

const BlogPage = () =>{
    return(
        <>
        <Navbar/>

        <div className="card2-card-body">
        <div class="card2_card_container">
        <Card/>
        <Card/>
        <Card/>
            </div>
        </div>
        
        <Footer/>
        </>
    )
}

export default BlogPage