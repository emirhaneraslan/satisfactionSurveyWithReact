import './Card.css'
import React from 'react'
import PropTypes from 'prop-types'


const button_on_click = ()=>{

}


const Card= ({picture_url,card_title,card_text,button_text,button_onClick}) => {
    

    
    return(
        <>
        

        <div class="card3-blog-post">
            <div class="card3-blog-post_img">
                <img className='card3-img' src={picture_url}
                    alt=""/>
            </div>
            <div class="card3-blog-post_info">
                
                <h1 class="card3-blog-post_title">{card_title}</h1>
                <p class="card3-blog-post_text">
                    {card_text}
                </p>
                <a onClick={button_onClick} class="card3-blog-post_cta">{button_text}</a>
            </div>
        </div>

    
        
        </>
    )
}

Card.propTypes = {
    picture_url:PropTypes.string,
    card_title:PropTypes.string,
    card_text:PropTypes.string,
    button_text:PropTypes.string,
    button_onClick:PropTypes.func
  }
  
  Card.defaultProps = {
    picture_url:"https://images.unsplash.com/photo-1612287230202-1ff1d85d1bdf?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTU3fHx0ZWNobm9sb2d5fGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60",
    card_title:"Lorem ipsum dolor sit amet.",
    card_text:"Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolores a, tempore veniam quasi sint",
    button_text:"Read More",
    button_onClick:button_on_click()
  }
  

export default Card