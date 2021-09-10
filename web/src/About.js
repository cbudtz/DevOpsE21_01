import {useParams} from 'react-router-dom';

export const About = ({match})=> {
    console.log(match)
    let {id} = useParams();
 return   (<h1>
        OHØJ! {id}
    </h1>)
}