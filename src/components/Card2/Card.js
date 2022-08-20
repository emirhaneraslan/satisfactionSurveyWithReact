import './Card.css'
import React from 'react'
import PropTypes from 'prop-types'


const Card= ({picture_url,created_by,created_date,card_title,card_text,button_text}) => {
    return(
        <>
        
        <div class="card2-blog-post">
            <div class="card2-blog-post_img">
                <img className='card2_img' src={picture_url}/>
            </div>
            <div class="card2-blog-post_info">
                <div class="card2-blog-post_date">
                    <span className='card2_span'>{created_by}</span>
                    <span className='card2_span'>{created_date}</span>
                </div>
                <h1 class="card2-blog-post_title">{card_title}</h1>
                <p class="card2-blog-post_text">
                    {card_text}
                </p>
                <a href="#" class="card2-blog-post_cta">{button_text}</a>
            </div>
        </div>

        </>
    )
}


Card.propTypes = {
    picture_url:PropTypes.string,
    created_by:PropTypes.string,
    created_date:PropTypes.string,
    card_title:PropTypes.string,
    card_text:PropTypes.string,
    button_text:PropTypes.string
    
  }
  
  Card.defaultProps = {
    picture_url:"https://images.unsplash.com/photo-1612287230202-1ff1d85d1bdf?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTU3fHx0ZWNobm9sb2d5fGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60",
    created_by:"Sagar Developer",
    created_date:"Nov 12 2021",
    card_title:"Lorem ipsum dolor sit amet.",
    card_text:"Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolores a, tempore veniam quasi sint",
    button_text:"Read More"
  }
  

export default Card