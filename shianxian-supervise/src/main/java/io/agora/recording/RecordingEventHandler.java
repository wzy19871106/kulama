package io.agora.recording;

import io.agora.recording.common.Common.AudioFrame;
import io.agora.recording.common.Common.VideoFrame;
import io.agora.recording.common.Common.AudioVolumeInfo;

public interface RecordingEventHandler {

    /** This callback returns the JNI instance. You need to pass this JNI instance
     * when calling each main method, except {@link RecordingSDK#createChannel() createChannel}.
     *
     * @param nativeHandle The recording engine.
     */
    void nativeObjectRef(long nativeHandle);

    /** This callback is triggered when a user leaves the channel.
     *
     * @param reason The reasons why the recording app leaves the channel. See {@link io.agora.recording.common.Common#LEAVE_PATH_CODE LEAVE_PATH_CODE}.
     */
    void onLeaveChannel(int reason);

    /** This callback is triggered when an error occurrs during SDK runtime.
     *
     * The SDK cannot fix the issue or resume running, which requires intervention
     * from the app and informs the user on the issue.
     *
     * @param error {@link io.agora.recording.common.Common#ERROR_CODE_TYPE Error codes}.
     * @param stat_code {@link io.agora.recording.common.Common#STAT_CODE_TYPE State codes}.
     */
    void onError(int error, int stat_code);

    /** This callback is triggered when a warning occurrs during SDK runtime.
     *
     * In most cases, the app can ignore the warnings reported by the SDK because
     * the SDK can usually fix the issue and resume running.
     *
     * @param warn {@link io.agora.recording.common.Common#WARN_CODE_TYPE Warning codes}.
     */
    void onWarning(int warn);

    /** This callback is triggered when the recording app successfully joins the specified
     * channel with an assigned Channel ID and user ID.
     *
     * @param channelId The channel ID assigned based on the channel name specified in {@link RecordingSDK#createChannel() createChannel}.
     * @param uid	User ID of the user.
     */
    void onJoinChannelSuccess(String channelId, long uid);

    /** This callback is triggered when a user leaves the channel or goes offline.
     *
     * The SDK reads the timeout data to determine if a user leaves the channel (or goes offline).
     * If no data package is received from the user within 15 seconds, the SDK assumes the user is offline.
     * A poor network connection may lead to false detections, so use signaling for reliable offline detection.
     *
     * @param uid User ID of the user.
     * @param reason The rerasons why the user leaves the channel or goes offline. See {@link io.agora.recording.common.Common#USER_OFFLINE_REASON_TYPE USER_OFFLINE_REASON_TYPE}.
     */
    void onUserOffline(long uid, int reason);

    /** This callback is triggered when a remote user/host joins the channel and reports the UID of the new user.
     *
     * <ul>
     *   <li>Communication profile: This callback notifies the recording application that a remote user joins the channel and reports the user's UID and information.</li>
     *   <li>Live broadcast profile: This callback notifies the recording application that a host joins the channel and reports the user's UID and information.</li>
     * </ul>
     * 
     * If there are users/hosts in the channel before the recording application joins the channel, the SDK also reports on the UIDs and information of the existing users/hosts. This callback is triggered as many times as the number of the users/hosts in the channel.
     *
     * @param uid The `uid` of the new user/host.
     * @param recordingDir	The relative path of the recorded files and recording log.
     */
  void onUserJoined(long uid, String recordingDir);

    /** This callback reports the user who speaks loudest.
     *
     * If you set the {@link io::agora::recording::common::RecordingConfig#audioIndicationInterval audioIndicationInterval} parameter in {@link io::agora::recording::common::RecordingConfig RecordingConfig} to be greater than 0, this callback returns the `uid` of the user with the highest voice volume over a certain time period.
     *
     * @param uid The `uid` of the user with the highest voice volume over a certain time period.
     */
  void onActiveSpeaker(long uid);

    /** This callback is triggered when the raw audio data is received.
     *
     * @param uid The `uid` of the user.
     * @param frame Received raw audio data in PCM or AAC format. See {@link AudioFrame AudioFrame}.
     */
    void audioFrameReceived(long uid, AudioFrame frame);

    /** This callback is triggered when the raw video data is received.
     *
     * This callback is triggered for every received raw video frame and can be used
     * to detect sexually explicit content, if necessary.
     *
     * Agora recommends capturing the I frame only and neglecting the others.
     *
     * @param uid User ID of the remote user as specified in the createChannel() method.
     * If no uid is previously assigned, the Agora server automatically assigns a uid.
     * @param type The format of the received video data:
     * <ul>
     *  <li>0: YUV</li>
     *  <li>1: H.264</li>
     *  <li>2: JPEG</li>
     * </ul>
     * @param frame Received video data in YUV, H.264, or JPEG format. See {@link VideoFrame VideoFrame}.
     * @param rotation Rotational angle: 0, 90, 180, or 270.
     */
    void videoFrameReceived(long uid, int type, VideoFrame frame, int rotation);

    /** The SDK triggers this callback when it stop to receive other callbacks and cannot call the JNI function.
     */
    void stopCallBack();

    /** This callback reports the relative path of the recorded files.
     * 
     *  @param path The relative path of the recorded files.
     */
    void recordingPathCallBack(String path);


    /** This callback reports the list of users who are speaking and their volumes.
     *
     * This callback works only when {@link io.agora.recording.common.RecordingConfig#audioIndicationInterval audioIndicationInterval} > 0.
     *
     * @param infos    An array containing the user ID and volume information for each speaker. For more information, see {@link io.agora.recording.common.Common#AudioVolumeInfo AudioVolumeInfo}.
     */
    void onAudioVolumeIndication(AudioVolumeInfo[] infos);

    /** This callback is triggered when the first remote video frame is received and decoded.
     *
     * @param uid     The user ID.
     * @param width   The width of the video frame.
     * @param height  The height of the video frame.
     * @param elapsed Time elapsed (ms) from the local user calling {@link RecordingSDK#createChannel() createChannel} until this callback is triggered.
     */
    void onFirstRemoteVideoDecoded(long uid, int width, int height, int elapsed);

    /** This callback is triggered when the first remote audio frame is received.
     *
     * @param uid      The user ID.
     * @param elapsed  Time elapsed (ms) from the local user calling {@link RecordingSDK#createChannel() createChannel} until this callback is triggered.
     */
    void onFirstRemoteAudioFrame(long uid, int elapsed);

    /** Occurs when the status of receiving the audio or video stream changes.
     * @param receivingAudio  Whether or not the recording application is receiving the audio stream.
     * @param receivingVideo  Whether or not the recording application is receiving the video stream.
     */
    void onReceivingStreamStatusChanged(boolean receivingAudio, boolean receivingVideo);

    /** Occurs when the SDK cannot reconnect to Agora's edge server 10 seconds after its connection to the server is interrupted.
     * 
     * The SDK triggers this callback when it cannot connect to the server 10 seconds after calling {@link RecordingSDK#createChannel() createChannel} regardless of whether it is in the channel or not.
     * 
     * This callback is different from {@link RecordingEventHandler#onConnectionInterrupted onConnectionInterrupted}:
     * <ul>
     *  <li> The SDK triggers the {@link RecordingEventHandler#onConnectionInterrupted onConnectionInterrupted} callback when the SDK loses connection with the server for more than 4 seconds after it joins the channel.</li>
     *  <li> The SDK triggers the {@link RecordingEventHandler#onConnectionLost onConnectionLost} callback when the SDK loses connection with the server for more than 10 seconds, regardless of whether it joins the channel or not.</li>
     * </ul>
     * 
     * For both callbacks, the SDK tries to reconnect to the server until the app calls {@link RecordingSDK#leaveChannel() leaveChannel}.
     */
    void onConnectionLost();

    /** Occurs when the connection between the SDK and the server is interrupted.
     * 
     * The SDK triggers this callback when it cannot connect to the server 10 seconds after calling {@link RecordingSDK#createChannel() createChannel} regardless of whether it is in the channel or not.
     * 
     * This callback is different from {@link RecordingEventHandler#onConnectionLost onConnectionLost}:
     * <ul>
     *  <li> The SDK triggers the {@link RecordingEventHandler#onConnectionInterrupted onConnectionInterrupted} callback when the SDK loses connection with the server for more than 4 seconds after it joins the channel.</li>
     *  <li> The SDK triggers the {@link RecordingEventHandler#onConnectionLost onConnectionLost} callback when the SDK loses connection with the server for more than 10 seconds, regardless of whether it joins the channel or not.</li>
     * </ul>
     * 
     * For both callbacks, the SDK tries to reconnect to the server until the app calls {@link RecordingSDK#leaveChannel() leaveChannel}.
     */
    void onConnectionInterrupted();
}
