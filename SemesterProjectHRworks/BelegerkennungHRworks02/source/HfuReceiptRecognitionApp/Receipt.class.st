Class {
	#name : 'Receipt',
	#superclass : 'HfuEstimatedReceipt',
	#instVars : [
		'netAmount',
		'netAmountbyGross',
		'netAmountbyGrossSeven',
		'netAmountbyGrossNineTeen',
		'grossAmount',
		'allWordsCollection',
		'date',
		'name',
		'jsonPath',
		'mwst'
	],
	#category : 'HfuReceiptRecognitionApp'
}

{ #category : 'Not categorized' }
Receipt >> allWordsCollection [

	^allWordsCollection
]

{ #category : 'Not categorized' }
Receipt >> allWordsCollection: anObject [

	allWordsCollection := anObject
]

{ #category : 'Not categorized' }
Receipt >> calculateNetfromGross: aGrossWord [

	| grossColletion  aNetAmount a b|
	a:=0.
	b:=0.
	aNetAmount := 0.
	
	grossColletion := aGrossWord subStrings: ','. 
	
	"Rechne subStrings zuSammen und erhalte Netto betrag"
	Transcript cr; show: '---in Calculate net from Gross---',(grossColletion at: 1), '     ', (grossColletion at: 2).

	a := (grossColletion at: 1) asNumber.
	b:=  (grossColletion at: 2) asNumber.
	
	Transcript cr; show: 'a: ' ,a , 'b: ' ,b.
	
	grossAmount :=b + (a* 100). 
	Transcript cr; show:  grossAmount printString.
	aNetAmount := ((grossAmount  / 119) *100) ceiling .
	self netAmountbyGrossNineTeen:  aNetAmount.
	aNetAmount := ((grossAmount / 107) *100) ceiling.
	self netAmountbyGrossSeven: aNetAmount.
	Transcript cr; show: ('+++NetAmount: ', aNetAmount) printString .

	self limitNetAmount: self allWordsCollection comparisonAmountSeven:  self netAmountbyGrossSeven comparisonAmountNineteen: self netAmountbyGrossNineTeen
	
]

{ #category : 'Not categorized' }
Receipt >> convertToCentAmount: aAmount [

	| amountCollection theCentAmount amountEuro amountCent |
	
		('*,##' match: aAmount)
		ifTrue: [
	
	
	amountCollection := aAmount subStrings: ','. 
	
	amountEuro := (amountCollection at: 1) asNumber.
	amountCent := (amountCollection at: 2) asNumber.
	
	theCentAmount := amountCent + (amountEuro * 100).
	
	Transcript cr; show: '€€€ ConvertToCentAmount:  ', theCentAmount printString .
	
	^theCentAmount
	
	]ifFalse: [
		^nil
	]

]

{ #category : 'Not categorized' }
Receipt >> fillAllWordsCollection [
		
	"FÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¼llt allWordsCollection mit WÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¶rtern von JSON File"

	
		| aReceiptResponseObject |
		
			
		self jsonPath isNil
		ifTrue: [^'Fehlerhafter Path'].
		
		
		ClwHttpRequest useSstHttpClient.
		ClwImageMagickStarter programPathOrName: 'C:\Program Files\ImageMagick-7.0.10-Q16\magick.exe'.
		ClwAwsCredentials
		newDefaultAccessKeyId: 'AKIAXSRJKNZ4IBSQ7NOG'
		secretAccessKey: '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'.
		aReceiptResponseObject := ClwTextractHelper debugReceiptWithLines: self jsonPath. 
		
		self allWordsCollection: aReceiptResponseObject allWords.
		"allWordsCollection ist OrderedCollection und wird mit allen WÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¶rtern von allWords befÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¼llt"
	
		
]

{ #category : 'Not categorized' }
Receipt >> fillAllWordsCollection: aPath [
		
	"FÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¼llt allWordsCollection mit WÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¶rtern von JSON File"
		| aAllWordsCollection aReceiptResponseObject |
		aReceiptResponseObject := ClwTextractHelper debugReceiptWithLines: aPath. 
		
		self allWordsCollection:  aReceiptResponseObject allWords.
		"allWordsCollection ist OrderedCollection und wird mit allen WÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¶rtern von allWords befÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¼llt"
	
		
]

{ #category : 'Not categorized' }
Receipt >> filterAllTextractLines [


	| aJsonCollection out  jsonDebugLines aTextTractText theMatchCollection |


	out := CfsWriteFileStream openEmpty:  'ausgabeAllerTextractLines'.
	jsonDebugLines := ClwTextractHelper debugReceiptWithLines: 'C:\Users\Dizzle\Desktop\Informatik\4.Semester\SemesterProjekt\Belege\TestSuite-1_Edited\a018.png'.  
	aJsonCollection := jsonDebugLines allWords.
	
	"allWordsCollection ist OrderedCollection und wird mit allen WÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¶rtern von allWords befÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¼llt"
	self allWordsCollection: aJsonCollection. 


	out nextPutAll: 'TextractLines Ausgabe'.
	out newLine.
		
			aJsonCollection do: [:eachAttribute |
			
			(eachAttribute match: '0.00')
				ifTrue:[ out nextPutAll: 'Match:  '; 
								  nextPutAll: eachAttribute ;
								  newLine;
								  yourself.
								  
								  self grossAmount: eachAttribute .
							
							].
		

		
		].
						out flush.
						out close.
						
						
						
			"^theMatchCollection"
	
	
	
	
			"out nextPutAll:  eachAttribute asString , eachAttribute blockType, '     ', eachAttribute id , '\t Text:          ' , eachAttribute  text;
		    	newLine;
				yourself.]."
]

{ #category : 'Not categorized' }
Receipt >> filterGrossAmount [
	"Filtert den BruttoBetrag"
	
	| aKeyWordsDictionary aAllWordsCollection aAllWordsCollection2 aBoolean theEachCollection theEachAmount 
	theEachCent theEachEuro highestAmount highestAmountEuro highestAmountCent matcher | 
	
	aKeyWordsDictionary := (Dictionary new
	 at: 1 put: 'Summe';
	 at: 2 put: 'Betrag';
	 at: 3 put: 'Gesamtbetrag';
	 at: 4 put: 'Bar';
	 at: 5 put: 'Gesamt';
	 at: 6 put: 'Brutto';
	 at: 7 put: 'EUR';
	 at: 8 put: 'Zwischensumme';
	 at: 9 put: 'Gesamt-Brutto';
	 at: 10 put: 'SUMME EUR';
	 at: 11 put: 'Total';
	 at: 12 put: 'Summe EURO';
	 at: 13 put: 'Barzahlung';
	 at: 14 put: 'GESAMT BRUTTO';
	 at: 15 put: 'zu zahlen';
	 at: 16 put: 'GESAMT:';
	 at: 17 put: 'Gesamtpreis';
	 at: 18 put: 'Rechnungsbetrag EUR';
	yourself).
	
	aBoolean := true.
	aAllWordsCollection2:= OrderedCollection  new.
	aAllWordsCollection := OrderedCollection  new.
	aAllWordsCollection:= self allWordsCollection.
	
		aAllWordsCollection doWithIndex:[
		:eachWord :index | (aKeyWordsDictionary includes: eachWord)
		ifTrue: [(aBoolean = true)
					ifTrue: [
					index to: aAllWordsCollection size do:[:eachWords |  
					aAllWordsCollection2 add: (aAllWordsCollection at: eachWords)].
					aBoolean := false.]]
	].
	
	aAllWordsCollection := OrderedCollection  new.
	aAllWordsCollection2 do: [:eachAttribut |  (('*,##' match: eachAttribut) or:['*.##' match: eachAttribut] )
	ifTrue: [ aAllWordsCollection add: eachAttribut]].
	
	highestAmountEuro := 0.
	highestAmountCent := 0.
	 
	
	aAllWordsCollection do:[
		:eachWord |
	 	Transcript cr; show: eachWord.
		"Ist eachWord ein GeldBetrag? "
		('*,##' match: eachWord)
		ifTrue: [
			 Transcript cr; show: '---' ,eachWord , '---'.
			
			theEachCollection := eachWord subStrings: ','. 
	 		Transcript cr; show: '###Collection at 1: ' ,(theEachCollection at: 1),' at 2:  ',(theEachCollection at: 2) ,'  --asNumber'.

			( ((theEachCollection at: 1) asNumber) >= highestAmountEuro)
			ifTrue: [
		 		Transcript cr; show: '+++Im ifBlock'.
				(((theEachCollection at: 2) asNumber) >= highestAmountCent)				
				ifTrue: [
			 		Transcript cr; show: '+++Im 2. ifBlock'.
					highestAmountEuro := (theEachCollection at: 1) asNumber.
					highestAmountCent := (theEachCollection at: 2) asNumber.
					Transcript cr; show: '+++highestAmountEuro: ' , highestAmountEuro printString  , 'Cent: ' , highestAmountCent printString.
					self grossAmount: eachWord.
				]
			]
		]
	].
	"gib den errechneten Brutto wert in die calculateNetfromGross: Methode"
	
	self calculateNetfromGross: grossAmount.
	
	^self grossAmount.
	
	
	
]

{ #category : 'Not categorized' }
Receipt >> filterHighestAmountInJson [
	"Filtert den BruttoBetrag"
	
	| theEachCollection theEachAmount theEachCent theEachEuro highestAmount highestAmountEuro highestAmountCent matcher |
	
	highestAmountEuro := 0.
	highestAmountCent := 0.
	 
	
	self allWordsCollection do:[
		:eachWord |
	 	Transcript cr; show: eachWord.
		"Ist eachWord ein GeldBetrag? "
		('*,##' match: eachWord)
		ifTrue: [
			 Transcript cr; show: '---' ,eachWord , '---'.
			
			theEachCollection := eachWord subStrings: ','. 
	 		Transcript cr; show: '###Collection at 1: ' ,(theEachCollection at: 1),' at 2:  ',(theEachCollection at: 2) ,'  --asNumber'.

			( ((theEachCollection at: 1) asNumber) >= highestAmountEuro)
			ifTrue: [
		 		Transcript cr; show: '+++Im ifBlock'.
				(((theEachCollection at: 2) asNumber) >= highestAmountCent)				
				ifTrue: [
			 		Transcript cr; show: '+++Im 2. ifBlock'.
					highestAmountEuro := (theEachCollection at: 1) asNumber.
					highestAmountCent := (theEachCollection at: 2) asNumber.
					Transcript cr; show: '+++highestAmountEuro: ' , highestAmountEuro printString  , 'Cent: ' , highestAmountCent printString.
					self grossAmount: eachWord.
				
				]
			]
		]
	].
	"gib den errechneten Brutto wert in die calculateNetfromGross: Methode"
	self calculateNetfromGross: self grossAmount.
	
	^self grossAmount.
]

{ #category : 'Not categorized' }
Receipt >> grossAmount [

	^grossAmount
]

{ #category : 'Not categorized' }
Receipt >> grossAmount: anObject [

	grossAmount := anObject
]

{ #category : 'Not categorized' }
Receipt >> jsonPath [

	^jsonPath
]

{ #category : 'Not categorized' }
Receipt >> jsonPath: anObject [

	jsonPath := anObject
]

{ #category : 'Not categorized' }
Receipt >> limitNetAmount: aNetCollection comparisonAmountSeven: aNetAmountSeven comparisonAmountNineteen: aNetAmountNineTeen [

	aNetCollection do: [:eachWord | | aNetAmount |
					
	aNetAmount := self convertToCentAmount: eachWord.
					
	Transcript cr; show: '###NetAmount vor ifTrue: ' , aNetAmount printString .
	

	aNetAmount isNil not
					ifTrue: [
						"Pruefe ob NettoBetrag mit 20Cent toleranz uebereinstimmt"
							((self netAmountbyGrossNineTeen + 10) >= aNetAmount and: [(self netAmountbyGrossNineTeen-10) <= aNetAmount])
							ifTrue:[
										self netAmount: aNetAmount.  
										self mwst: 19.
									Transcript cr; show: '###NetAmount gefiltert 19%:  ' , aNetAmount.
								].
								
							((self netAmountbyGrossSeven+ 10) >= aNetAmount and: [(self netAmountbyGrossSeven-10) <= aNetAmount])	
							ifTrue:[
										self netAmount: aNetAmount. 
										self mwst: 7.
									Transcript cr; show: '###NetAmount gefiltert 7% :  ' , aNetAmount.].
							]
							].
]

{ #category : 'Not categorized' }
Receipt >> mwst [

	^mwst
]

{ #category : 'Not categorized' }
Receipt >> mwst: anObject [

	mwst := anObject
]

{ #category : 'Not categorized' }
Receipt >> netAmount [

	^ netAmount
]

{ #category : 'Not categorized' }
Receipt >> netAmount: anObject [

	netAmount := anObject
]

{ #category : 'Not categorized' }
Receipt >> netAmountbyGross [

	^netAmountbyGross
]

{ #category : 'Not categorized' }
Receipt >> netAmountbyGross: anObject [

	netAmountbyGross := anObject
]

{ #category : 'Not categorized' }
Receipt >> netAmountbyGrossNineTeen [

	^netAmountbyGrossNineTeen
]

{ #category : 'Not categorized' }
Receipt >> netAmountbyGrossNineTeen: anObject [

	netAmountbyGrossNineTeen := anObject
]

{ #category : 'Not categorized' }
Receipt >> netAmountbyGrossSeven [

	^netAmountbyGrossSeven
]

{ #category : 'Not categorized' }
Receipt >> netAmountbyGrossSeven: anObject [

	netAmountbyGrossSeven := anObject
]

{ #category : 'Not categorized' }
Receipt >> scanReceipt: aReceiptPath [
	"Scannt einnen kompletten Beleg und fÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¼llt alle instanceVariableNames"
	
	| out |
	
	out := CfsWriteFileStream openEmpty:  'ScanKassenZettel'.


	self jsonPath: aReceiptPath.
	self fillAllWordsCollection.
	self filterGrossAmount.
	
	"Schreibe attribute in TextDatei"
	
	out nextPutAll: 'KassenZettel: ';
		nextPutAll: self jsonPath.
		out newLine.
		
	out nextPutAll: 'BruttoBetrag: ';
		  nextPutAll:self grossAmount printString.
		  out newLine.
		  
	out nextPutAll: 'NettoBetrag berechnet durch HighesAmount 19% MwSt: ';
		nextPutAll: self netAmountbyGrossNineTeen printString.
		out newLine.

		
	out nextPutAll: 'NettoBetrag berechnet durch HighesAmount 7% MwSt: :';
		nextPutAll: self netAmountbyGrossSeven printString.
		out newLine.

		
	out nextPutAll: 'NettoBetrag berechnet durch limitNetAmount Methode: ';
		nextPutAll: self netAmount printString.
		out newLine.
		
	out nextPutAll: 'MehrwertSteuer: ';
		nextPutAll: self mwst printString;
		nextPutAll:  ' %'.
		out newLine.
		
		out flush.
		out close.
	
	
	
	^self
	
	
	
	"self grossAmount: self allWordsCollection filterGrossAmount."
	


]
