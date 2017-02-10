#! /bin/bash
echo 'convert dir: ' $1
cd $1
ls | while read d; do
        if [ -d $d ]; then
                echo 'processing dir: ' $d ' ...'
                cd $d
                ls | while read f; do
                        if [ -f $f ]; then
#count=`expr $count + 1`
                                echo 'convert file: ' $f
                                iconv -f 'GBK' -t 'UTF-8' $f > $f.bak
                                rm $f
                                mv $f.bak $f
                        fi
                done
                cd ..
        fi
done
cd ..