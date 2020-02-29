$cha=''
$finalchar=''
$regex="([A][C][R][.][N][a][m][e][:])+"
$regex1="([A][C][R][.][N][a][m][e][:][ ]['][a-zA-Z])+"
foreach($line in Get-Content azure-pipelines.yml) 
{
    if($line -match $regex)
    {
        $lines = $line.toCharArray()
        foreach($character in $lines)
        {
            $cha=$cha+$character
            if($cha -match $regex1)
            {
                if($character -ne "'")
                {
                    $finalchar=$finalchar+$character
                }
            }
         
        }
    }
 }

$text=Get-Content -Path copyit.txt
$ConfigFile = "azure-pipelines.yml"
$content = [System.IO.File]::ReadAllText($ConfigFile).Replace("$finalchar",$text)
[System.IO.File]::WriteAllText($ConfigFile, $content)
