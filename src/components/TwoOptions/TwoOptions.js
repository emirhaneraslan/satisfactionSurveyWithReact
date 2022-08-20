import './TwoOptions.css'
import React from 'react'
import PropTypes from 'prop-types'

const TwoOptions = ({question,name,html_for1,html_for2,optionOnChange})=> {
    return(
        <>
        <div onChange={optionOnChange} className="twooption2-radio-container">
        <h5>{question}</h5>
      <input value={"Katılıyorum"} className='twooption2_input' type="radio" id={html_for1} name={name} />
      <label className='twooption2_label' htmlFor={html_for1}>Katılıyorum</label>

      <input value={"Katılmıyorum"} className='twooption2_input' type="radio" id={html_for2} name={name} />
      <label className='twooption2_label' htmlFor={html_for2}>Katılmıyorum</label>

      <hr className='horizontal'/>
    </div>
        </>
    )
}

TwoOptions.propTypes = {
    question:PropTypes.string
  }
  
TwoOptions.defaultProps = {
    question:"Selamun Aleyküm"
  }


export default TwoOptions