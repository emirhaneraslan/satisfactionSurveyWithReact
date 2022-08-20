import './Card.css'
import React from 'react'
import PropTypes from 'prop-types'
import DataButton from '../../components/DataButton/DataButton'


const Card = ({picture_url,card_title,button_text,button_href,button_onClick}) => {
    return(
        <>
        

              <div className="col-md-6">
                <div className="card">
                  <img className="card1-img-top" src={picture_url}/>
                  <div className="card1-body">
                    <h4 className="card1-title">{card_title}</h4>
                  </div>
                  <div className="container">
                    <div className="row">
                      <div className="col"></div>
                      <div className="col-8">
                      <DataButton button_text={button_text} button_href={button_href} button_onClick={button_onClick}/>
                      </div>
                      <div className="col"></div>
                    </div>
                  </div>
                  
                </div>
              </div>
              
            
        </>
    )
}

Card.propTypes = {
  picture_url:PropTypes.string,
  card_title:PropTypes.string,
  card_text:PropTypes.string,
  button_text:PropTypes.string
}

Card.defaultProps = {
  picture_url:"https://images.unsplash.com/photo-1659425191734-773850835dad?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=987&q=80",
  card_title:"Lorem ipsum dolor.",
  card_text:"Lorem ipsum dolor sit amet consectetur adipisicing elit. Quis, autem.",
  button_text:"Tıklayınız..."
}

export default Card