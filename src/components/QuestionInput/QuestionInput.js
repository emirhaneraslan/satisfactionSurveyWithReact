import DataInput from '../DataInput/DataInput'
import './QuestionInput.css'



const QuestionInput = ({label_text,input_ref,input_onChange,option1_text,option2_text,option3_text,select_ref,selectOnClick}) => {

    
    

    
        
        

      
    return(
        <>
        <div className="container">
            <div className="row">
                <div className="col-9"><DataInput label_text={label_text} input_ref={input_ref} input_onChange={input_onChange}/></div>
                <div className="col-3">
                    <div className="questioninput_selects">
            <select onClick={selectOnClick} ref={select_ref} className='questioninput_select' name="format" id="format">
                <option  disabled>Choose a question type</option>
                
                <option selected  value="1">{option1_text}</option>
                <option  value="2">{option2_text}</option>
                <option  value="3">{option3_text}</option>
                
            </select>
        </div>
    </div>
</div>
        </div>
        </>
    )
}

export default QuestionInput