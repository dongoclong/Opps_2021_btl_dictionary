package TuDienP1;
import com.sun.speech.freetts.VoiceManager; 
public class speech {

public void speech(String text) {
VoiceManager voiceManager = VoiceManager.getInstance();
com.sun.speech.freetts.Voice syntheticVoice = voiceManager.getVoice("kevin");
syntheticVoice.allocate();
syntheticVoice.speak(text);
syntheticVoice.deallocate();
}
}

