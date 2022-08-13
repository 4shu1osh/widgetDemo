import React from 'react';
import { NativeModules, Text } from 'react-native';
const { CalendarModule } = NativeModules;
const SharedStorage = NativeModules.SharedStorage;



console.log(NativeModules);

export default function App() {

  const [count, setCount] = React.useState(0)

  const handleSubmit = async () => {
    CalendarModule.createCalendarEvent(`count: ${count}`, 'testLocation');

    // try {
    //   // iOS
    //   await SharedGroupPreferences.setItem('widgetKey', {text: "hello"}, group);
    // } catch (error) {
    //   console.log({error});
    // }
  };

  React.useEffect (()=> {
    SharedStorage.set(
      JSON.stringify({
        text: 'fff'
      })
     );
    // handleSubmit()
    // count < 10 && setTimeout(()=>{
    //   setCount(count+1)
    // },1000)
  },[count])

   
  return (
    <Text onPress={handleSubmit}>Press Me</Text>
  );
}