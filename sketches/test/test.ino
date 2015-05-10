const unsigned long interval_1 = 500;
unsigned long timer_1;
const unsigned long interval_2 = 200;
unsigned long timer_2;
void setup(){
    pinMode(13,OUTPUT);
    timer_1 = millis();
    pinMode(14,OUTPUT);
    timer_2 = millis();
}
void loop(){
    if((millis() - timer_1) >= interval_1){
    togglePin_1 ();
   }
    if((millis() - timer_2) >= interval_2){
    togglePin_2 ();
   }
}
void togglePin_1 (){
    if(digitalRead(13)  ==  LOW){
    digitalWrite(13,true);
   }
    else{
    digitalWrite(13,false);
   }
    timer_1 = millis();
}
void togglePin_2 (){
    if(digitalRead(14)  ==  LOW){
    digitalWrite(14,true);
   }
    else{
    digitalWrite(14,false);
   }
    timer_2 = millis();
}
