import './FiveOptions.css'
import PropTypes from 'prop-types'
import React from "react"

const FiveOptions = ({question,name,html_for1,html_for2,html_for3,html_for4,html_for5,optionOnChange})=> {
    return(
        <>
        <div onChange={optionOnChange} className="radio-container-five">
        <h5>{question}</h5>
      <input value={"Kesinlikle Katılıyorum"} className='fiveoption5_input' type="radio" id={html_for1} name={name} />
      <label  className='fiveoption5_label' htmlFor={html_for1}>Kesinlikle Katılıyorum</label>

      <input value={"Katılıyorum"} className='fiveoption5_input' type="radio" id={html_for2} name={name} />
      <label className='fiveoption5_label' htmlFor={html_for2}>Katılıyorum</label>

      <input value={"Emin Değilim"} className='fiveoption5_input' type="radio" id={html_for3} name={name} />
      <label className='fiveoption5_label' htmlFor={html_for3}>Emin Değilim</label>

      <input value={"Katılmıyorum"} className='fiveoption5_input' type="radio" id={html_for4} name={name} />
      <label className='fiveoption5_label' htmlFor={html_for4}>Katılmıyorum</label>

      <input value={"Kesinlikle Katılmıyorum"} className='fiveoption5_input' type="radio" id={html_for5} name={name} />
      <label className='fiveoption5_label' htmlFor={html_for5}>Kesinlikle Katılmıyorum</label>
      
      <hr className='horizontal'/>
    </div>
        </>
    )
}

FiveOptions.propTypes = {
    question:PropTypes.string
  }
  
  FiveOptions.defaultProps = {
    question:"Selamun Aleyküm"
  }

export default FiveOptions