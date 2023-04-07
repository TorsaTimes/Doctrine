Class {
	#name : 'HfuEstimatedReceipt',
	#superclass : 'Object',
	#classVars : [
		'ReceiptText'
	],
	#category : 'HfuReceiptRecognitionApp'
}

{ #category : 'Not categorized' }
HfuEstimatedReceipt class >> receiptText [
	"The following source failed to compile (all double quotes have been doubled):"
"


	ClwHttpRequest useSstHttpClient.
	ClwImageMagickStarter programPathOrName: 'C:\Program Files\ImageMagick-7.0.10-Q16\magick.exe'.
	ClwAwsCredentials
	 newDefaultAccessKeyId: 'AKIAXSRJKNZ4IBSQ7NOG'
	 secretAccessKey: '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'.
ClwTextractHelper debugReceiptWithLines: 'E:\Studium\Studium 4\SemesterProjekt\codeImport\BelegeBilder\TestSuite-1_Edited\a030.png' ClwTextractHelper."
#tonelCompilationFailure.

^ self halt: 'The source for this method failed to compile' 
]
